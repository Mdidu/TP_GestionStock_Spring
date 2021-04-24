package formation.services;

import java.util.Date;
import java.util.List;

import formation.persistence.entities.Commande;
import formation.persistence.entities.Etat;
import formation.persistence.entities.Produit;


public interface CommandeService extends GlobalService<Commande> {
	
	List<Commande> findByEtat(Etat etat);
	List<Commande> findByDate(Date dateDebut, Date dateFin);
	public List<Commande> findByProduit(Produit produit);
	
}
