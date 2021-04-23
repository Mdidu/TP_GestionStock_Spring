package formation.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Client;

public interface ClientRepository extends CrudRepository<Client, BigDecimal> {

	List<Client> findByNomclient(String nomclient);
	List<Client> findByPrenomclient(String prenomclient);
}
