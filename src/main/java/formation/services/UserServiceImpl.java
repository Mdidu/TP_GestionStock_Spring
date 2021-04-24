package formation.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import formation.persistence.entities.Stockuser;
import formation.repositories.UserRepository;

@Service("userService")
@Transactional
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
