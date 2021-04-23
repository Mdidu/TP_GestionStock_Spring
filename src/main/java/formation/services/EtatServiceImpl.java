package formation.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import formation.persistence.entities.Commande;
import formation.persistence.entities.CommandeId;
import formation.persistence.entities.Etat;
import formation.repositories.CommandeRepository;
import formation.repositories.EtatRepository;

@Service("etatService")
@Transactional
public class EtatServiceImpl implements EtatService {

	@Autowired
	EtatRepository etatRepository;
	
	@Override
	public void add(Etat commande) {
	}

	@Override
	public void delete(Etat commande) {
	}

	@Override
	public void update(Etat commande) {
	}

	@Override
	public List<Etat> findAll() {
        return (List<Etat>) etatRepository.findAll();
	}

	@Override
	public Etat findById(Serializable id) {
		return null;
	}

}
