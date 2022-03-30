package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IAdminProduitDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

@Service
public class AdminProduitServiceImpl implements IAdminProduitService {

	@Autowired
	IAdminProduitDao prodDao;

	@Override
	public boolean addProduct(Produit prodIn, Categorie catIn) {

		prodIn.setCategorie(catIn);

		return prodDao.addProduct(prodIn);
	}

	@Override
	public boolean updateProduct(Produit prodIn) {

		return prodDao.updateProduct(prodIn);
	}

	@Override
	public Produit getProductById(Produit prodIn) {

		return prodDao.getProductById(prodIn);
	}

	@Override
	public boolean deleteProduct(Produit prodIn) {

		return prodDao.deleteProduct(prodIn);
	}

}
