package formation.repositories;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Adresse;

public interface AdresseRepository extends CrudRepository<Adresse, BigDecimal>{

}
