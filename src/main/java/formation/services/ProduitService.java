package formation.services;

import java.util.List;

import formation.persistence.entities.Produit;

public interface ProduitService extends GlobalService<Produit> {
	
	List<Produit> findByDesignation(String designation);
	List<Produit> findByMarque(String marque);
}
