package formation.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.persistence.entities.Categorie;
import formation.repositories.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public void add(Categorie categorie) {
		categorieRepository.save(categorie);
	}

	@Override
	public void delete(Categorie categorie) {
		categorieRepository.delete(categorie);
	}

	@Override
	public void update(Categorie categorie) {
		categorieRepository.save(categorie);
	}

	@Override
	public List<Categorie> findAll() {
        return (List<Categorie>) categorieRepository.findAll();
	}

	@Override
	public Categorie findById(Serializable id) {
        return categorieRepository.findOne((BigDecimal) id);
	}

}
