package formation.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import formation.persistence.entities.Client;
import formation.repositories.ClientRepository;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void add(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public void update(Client client) {
		clientRepository.save(client);
	}

	@Override
	public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client findById(Serializable id) {
        return clientRepository.findOne((BigDecimal) id);
	}
	
	@Override
	public List<Client> findByNom(String nomclient) {
		return clientRepository.findByNomclient(nomclient);
	}
 
	@Override
	public List<Client> findByPrenom(String prenomclient) {
		return clientRepository.findByPrenomclient(prenomclient);
	}

}
