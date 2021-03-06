package view.managedBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import formation.persistence.entities.Role;
import formation.persistence.entities.Stockuser;
import formation.services.UserService;

@ManagedBean
@SessionScoped
public class UserMBean {

	private Stockuser user = new Stockuser();
	private Stockuser selectedUser = new Stockuser();

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	private List<Stockuser> listUsers = new ArrayList<Stockuser>();
	private String test = "test";
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Stockuser getUser() {
		return user;
	}

	public void setUser(Stockuser user) {
		this.user = user;
	}

	public Stockuser getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(Stockuser selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<Stockuser> getListUsers() {
		listUsers = userService.findAll();
		return listUsers;
	}

	public void setListUsers(List<Stockuser> listUsers) {
		this.listUsers = listUsers;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void addUser(ActionEvent e) {
		Role role = new Role();
		role.setIdrole(new BigDecimal(1));
		user.setRole(role);
		userService.add(user);
		user = new Stockuser();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}
	
	public void deleteUser(ActionEvent e) {
		if(selectedUser == null || selectedUser.getIduser() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention" ,"Aucun utilisateur n'a été sélectionné !"));
		} else {
			userService.delete(selectedUser);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppresion effectué avec succès"));
		}
	}
	
	public String editUser() {
		return "editUser.xhtml";
	}
	
	public void updateUser(ActionEvent e) {
		userService.update(selectedUser);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}

	public String login() {
		
		Stockuser userLog = userService.findUserByLoginAndPassword(user.getLogin(),user.getPassword());
		
		if(userLog != null) {
			HttpSession session = SessionUtils.getSession();
			
			
			BigDecimal userLogId = userLog.getRole().getIdrole();
			String userLogNom = userLog.getLogin();
			
			session.setAttribute("id", userLogId);
			session.setAttribute("nom", userLogNom);

			return "accueil.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention", "Utilisateur inexistant"));
			return "login.xhtml";
		}
	}
}
