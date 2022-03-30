package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IBoutiqueDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

@Service
public class BoutiqueServiceImpl implements IBoutiqueService {

	@Autowired
	IBoutiqueDao bDao;

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategoryById(Categorie categorie) {

		return bDao.getCategoryById(categorie);
	}

	@Override
	public List<Produit> getAllProducts() {

		return bDao.getAllProducts();
	}

	@Override
	public List<Produit> getAllProducts(Categorie categorie) {

		return bDao.getAllProducts(categorie);
	}

	@Override
	public List<Produit> getAllProducts(Produit produit) {

		return bDao.getAllProducts(produit);
	}

	@Override
	public List<Produit> getAllProducts(Panier panier) {

		return bDao.getAllProducts(panier);
	}

	// Retour d'un produit par son id
	public Produit getProductById(Produit produit) {

		return bDao.getProductById(produit);
	}

	@Override
	public void addProductToCart(Panier panier, Produit produit, int quantite) {

		bDao.addProductToCart(panier, produit, quantite);
	}

	@Override
	public void removeProductFromCart(Panier panier, Produit produit) {

		bDao.removeProductFromCart(panier, produit);
	}

	@Override
	public boolean saveOrder(Commande commande) {

		return bDao.saveOrder(commande);
	}

}
