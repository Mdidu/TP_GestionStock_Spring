package formation.services;

import formation.persistence.entities.Stockuser;

public interface UserService extends GlobalService<Stockuser> {

	/**
	 * Vérification de la connexion
	 * @param login
	 * @param password
	 * @return
	 */
	Stockuser findUserByLoginAndPassword(String login, String password);
}
