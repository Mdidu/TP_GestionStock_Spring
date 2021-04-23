package formation.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, BigDecimal> {

	List<Produit> findByDesignproduit(String designation);
	List<Produit> findByMarqueproduit(String marque);
}
