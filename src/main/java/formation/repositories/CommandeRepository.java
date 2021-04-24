package formation.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Commande;
import formation.persistence.entities.CommandeId;
import formation.persistence.entities.Etat;
import formation.persistence.entities.Produit;

public interface CommandeRepository extends CrudRepository<Commande, CommandeId> {

	List<Commande> findByEtat(Etat etat);
	@Query(value = "select c from Commande c where dateCommande between ?1 and ?2")
	List<Commande> findByDatecommande(Date dateDebut, Date dateFin);
	public List<Commande> findByProduit(Produit produit);
}
