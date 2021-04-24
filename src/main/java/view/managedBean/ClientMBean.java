package view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import formation.persistence.entities.Client;
import formation.persistence.entities.Role;
import formation.services.ClientService;

@ManagedBean
@SessionScoped
public class ClientMBean {

	private Client client = new Client();
	private Client selectedClient = new Client();
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;
	private List<Client> listClient = new ArrayList<Client>();
	private String valeurRecherche;
	private String critereRecherche;

	public ClientMBean() {
	}
	
	@PostConstruct
	public void init() {

		this.listClient = clientService.findAll();

	}

	public String getCritereRecherche() {
		return critereRecherche;
	}

	public void setCritereRecherche(String text2) {
		this.critereRecherche = text2;
	}

	public void renvoi(ActionEvent e) {
		if (critereRecherche.equalsIgnoreCase("none") || critereRecherche == null)
			this.listClient = clientService.findAll();
		
		else if (critereRecherche.equalsIgnoreCase("nom"))
			this.listClient = clientService.findByNom(valeurRecherche);
		
		else if (critereRecherche.equalsIgnoreCase("prenom"))
			this.listClient = clientService.findByPrenom(valeurRecherche);
		
		critereRecherche = null;
		valeurRecherche = null;
	}

	public String getValeurRecherche() {
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		this.valeurRecherche = valeurRecherche;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public void addClient(ActionEvent e) {
		Role role = new Role();
		role.setIdrole(new BigDecimal(2));
		client.getStockuser().setRole(role);
		clientService.add(client);
		client = new Client();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}

	public void deleteClient(ActionEvent e) {
		if (selectedClient == null || selectedClient.getIdclient() == new BigDecimal(0))
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucun  client sélectionné"));
		else {
			clientService.delete(selectedClient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression effectué avec succès"));
		}
	}

	public String editClient() {
		return "editClient.xhtml";
	}

	public void updateClient(ActionEvent e) {
		clientService.update(selectedClient);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}
}
