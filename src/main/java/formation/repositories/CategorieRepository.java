package formation.repositories;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Categorie;

public interface CategorieRepository extends CrudRepository<Categorie, BigDecimal> {

}
