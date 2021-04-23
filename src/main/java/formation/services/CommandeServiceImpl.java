package formation.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import formation.persistence.entities.Client;
import formation.persistence.entities.Commande;
import formation.persistence.entities.CommandeId;
import formation.persistence.entities.Etat;
import formation.persistence.entities.Produit;
import formation.repositories.ClientRepository;
import formation.repositories.CommandeRepository;

@Service("commandeService")
@Transactional
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	
	@Override
	public void add(Commande commande) {
		commandeRepository.save(commande);
	}

	@Override
	public void delete(Commande commande) {
		commandeRepository.delete(commande);
	}

	@Override
	public void update(Commande commande) {
		commandeRepository.save(commande);
	}

	@Override
	public List<Commande> findAll() {
        return (List<Commande>) commandeRepository.findAll();
	}

	@Override
	public Commande findById(Serializable id) {
        return commandeRepository.findOne((CommandeId) id);
	}

	@Override
	public List<Commande> findByEtat(BigDecimal idetat) {
		return commandeRepository.findByEtat(idetat);
	}
	
	public List<Commande> findByProduit(Produit produit) {
		return commandeRepository.findByProduit(produit);
	}
	
	@Override
	public List<Commande> findByDate(Date dateDebut,Date dateFin) {
		return commandeRepository.findByDatecommande(dateDebut, dateFin);
	}
}
