package formation.persistence.entities;
// Generated 15 avr. 2021 � 11:09:42 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Stockuser generated by hbm2java
 */
@Entity
@Table(name = "STOCKUSER", schema = "GESTION")
public class Stockuser implements java.io.Serializable {

	private BigDecimal iduser;
	private Role role;
	private String login;
	private String password;
	private Set<Client> clients = new HashSet<Client>(0);

	public Stockuser() {
	}

	public Stockuser(BigDecimal iduser) {
		this.iduser = iduser;
	}

	public Stockuser(BigDecimal iduser, Role role, String login, String password, Set<Client> clients) {
		this.iduser = iduser;
		this.role = role;
		this.login = login;
		this.password = password;
		this.clients = clients;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name="user_generator", sequenceName = "user_seq", allocationSize=50)
	@Column(name = "IDUSER", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIduser() {
		return this.iduser;
	}

	public void setIduser(BigDecimal iduser) {
		this.iduser = iduser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDROLE")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "LOGIN", length = 80)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD", length = 320)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stockuser")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}