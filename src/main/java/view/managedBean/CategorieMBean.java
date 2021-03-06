package view.managedBean;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import formation.persistence.entities.Categorie;
import formation.services.CategorieService;

@ManagedBean
@SessionScoped
public class CategorieMBean {

	private Categorie categorie = new Categorie();
	private Categorie selectedCategorie = new Categorie();

	@ManagedProperty(value = "#{categorieService}")
	private CategorieService categorieService;

	private List<Categorie> listCategorie;
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public List<Categorie> getListCategorie() {
		listCategorie = categorieService.findAll();
		return listCategorie;
	}

	public void setListCategorie(List<Categorie> listCategorie) {
		this.listCategorie = listCategorie;
	}

	public CategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public void addCategorie(ActionEvent e) {
		categorieService.add(categorie);
		categorie = new Categorie();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}

	public void deleteCategorie(ActionEvent e) {
		if (selectedCategorie == null || selectedCategorie.getIdcateg() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucune categorie sélectionné"));
		} else {
			categorieService.delete(selectedCategorie);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppression effectué avec succès"));
		}
	}

	public String editCategorie() {
		if (selectedCategorie == null || selectedCategorie.getIdcateg() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Aucune categorie sélectionné"));
			return "showCategorie.xhtml";
		} else {
			return "editCategorie.xhtml";
		}
	}

	public void updateCategorie(ActionEvent e) {
		categorieService.update(selectedCategorie);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}
}
