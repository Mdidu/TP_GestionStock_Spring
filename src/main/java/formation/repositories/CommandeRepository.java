package formation.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Commande;
import formation.persistence.entities.CommandeId;
import formation.persistence.entities.Produit;

public interface CommandeRepository extends CrudRepository<Commande, CommandeId> {

	List<Commande> findByEtat(BigDecimal etat);
	List<Commande> findByDatecommande(Date dateDebut, Date dateFin);
	public List<Commande> findByProduit(Produit produit);
}
