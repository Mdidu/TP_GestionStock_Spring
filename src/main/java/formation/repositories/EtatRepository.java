package formation.repositories;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Etat;

public interface EtatRepository extends CrudRepository<Etat, BigDecimal> {

}
