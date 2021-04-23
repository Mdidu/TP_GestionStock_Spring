package formation.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.persistence.entities.Commande;
import formation.persistence.entities.CommandeId;
import formation.persistence.entities.Stockuser;
import formation.repositories.CommandeRepository;
import formation.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void add(Stockuser user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Stockuser user) {
		userRepository.delete(user);
	}

	@Override
	public void update(Stockuser user) {
		userRepository.save(user);
	}

	@Override
	public List<Stockuser> findAll() {
        return (List<Stockuser>) userRepository.findAll();
	}

	@Override
	public Stockuser findById(Serializable id) {
        return userRepository.findOne((BigDecimal) id);
	}

	@Override
	public Stockuser findUserByLoginAndPassword(String login, String password) {
		return userRepository.findUserByLoginAndPassword(login, password);
	}

}
