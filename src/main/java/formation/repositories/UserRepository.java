package formation.repositories;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import formation.persistence.entities.Stockuser;

public interface UserRepository extends CrudRepository<Stockuser, BigDecimal> {
	Stockuser findUserByLoginAndPassword(String login, String password);
}
