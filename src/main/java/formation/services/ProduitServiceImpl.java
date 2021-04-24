package formation.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import formation.persistence.entities.Produit;
import formation.repositories.ProduitRepository;

@Service("produitService")
@Transactional
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Override
	public void add(Produit produit) {
		produitRepository.save(produit);
	}

	@Override
	public void delete(Produit produit) {
		produitRepository.delete(produit);
	}

	@Override
	public void update(Produit produit) {
		produitRepository.save(produit);
	}

	@Override
	public List<Produit> findAll() {
        return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public Produit findById(Serializable id) {
        return produitRepository.findOne((BigDecimal) id);
	}

    @Override
    public List<Produit> findByDesignation(String designation) {
    	return produitRepository.findByDesignproduit(designation);
    }

    @Override
    public List<Produit> findByMarque(String marque) {
    	return produitRepository.findByMarqueproduit(marque);
    }
    
}
