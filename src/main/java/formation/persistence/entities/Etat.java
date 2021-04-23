package formation.persistence.entities;
// Generated 15 avr. 2021 � 11:09:42 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Etat generated by hbm2java
 */
@Entity
@Table(name = "ETAT", schema = "GESTION")
public class Etat implements java.io.Serializable {

	private BigDecimal idetat;
	private BigDecimal nometat;
	private Set<Commande> commandes = new HashSet<Commande>(0);

	public Etat() {
	}

	public Etat(BigDecimal idetat) {
		this.idetat = idetat;
	}

	public Etat(BigDecimal idetat, BigDecimal nometat) {
		this.idetat = idetat;
		this.nometat = nometat;
	}

	public Etat(BigDecimal idetat, BigDecimal nometat, Set<Commande> commandes) {
		this.idetat = idetat;
		this.nometat = nometat;
		this.commandes = commandes;
	}

	@Id
	@Column(name = "IDETAT", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdetat() {
		return this.idetat;
	}

	public void setIdetat(BigDecimal idetat) {
		this.idetat = idetat;
	}

	@Column(name = "NOMETAT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getNometat() {
		return this.nometat;
	}

	public void setNometat(BigDecimal nometat) {
		this.nometat = nometat;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "etat")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
