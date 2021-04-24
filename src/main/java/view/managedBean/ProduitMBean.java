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

import formation.persistence.entities.Produit;
import formation.services.ProduitService;

@ManagedBean
@SessionScoped
public class ProduitMBean {

	private Produit produit = new Produit();
	private Produit selectedProduit = new Produit();

	@ManagedProperty(value = "#{produitService}")
	private ProduitService produitService;
	private List<Produit> listProduit = new ArrayList<Produit>();
	private String valeurRecherche;
	private String critereRecherche;

	public ProduitMBean() {
	}
	
	@PostConstruct
	public void init() {

		listProduit = produitService.findAll();
	}
	
	public String getValeurRecherche() {
		return valeurRecherche;
	}

	public void setValeurRecherche(String valeurRecherche) {
		this.valeurRecherche = valeurRecherche;
	}

	public String getCritereRecherche() {
		return critereRecherche;
	}

	public void setCritereRecherche(String critereRecherche) {
		this.critereRecherche = critereRecherche;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Produit getSelectedProduit() {
		return selectedProduit;
	}

	public void setSelectedProduit(Produit selectedProduit) {
		this.selectedProduit = selectedProduit;
	}

	public List<Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}

	public ProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}

	public void addProduit(ActionEvent e) {
		produitService.add(produit);
		produit = new Produit();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}

	public void deleteProduit(ActionEvent e) {
		if (selectedProduit == null || selectedProduit.getIdproduit() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucun produit sélectionné"));
		} else {
			produitService.delete(selectedProduit);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression effectué avec succès"));
		}
	}

	public String editProduit() {
		if (selectedProduit == null || selectedProduit.getIdproduit() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucun produit sélectionné"));
			return "showProduit.xhtml";
		} else {
			return "editProduit.xhtml";
		}
	}

	public void updateProduit(ActionEvent e) {
		produitService.update(selectedProduit);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}

	public void renvoi(ActionEvent e) {
		if (critereRecherche.equalsIgnoreCase("none") || critereRecherche == null)
			this.listProduit = produitService.findAll();

		else if (critereRecherche.equalsIgnoreCase("designation"))
			this.listProduit = produitService.findByDesignation(valeurRecherche);

		else if (critereRecherche.equalsIgnoreCase("marque"))
			this.listProduit = produitService.findByMarque(valeurRecherche);

		critereRecherche = null;
		valeurRecherche = null;
	}
}
