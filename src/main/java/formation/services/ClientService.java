package formation.services;

import java.util.List;

import formation.persistence.entities.Client;

public interface ClientService extends GlobalService<Client> {
	
	List<Client> findByNom(String nomclient);
	List<Client> findByPrenom(String prenomclient);
	
}
