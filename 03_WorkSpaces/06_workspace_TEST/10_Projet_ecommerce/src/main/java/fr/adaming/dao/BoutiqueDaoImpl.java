package fr.adaming.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;

//Annotation pour déclarer la classe comme un component Dao
@Repository
public class BoutiqueDaoImpl implements IBoutiqueDao {

	@Autowired
	private SessionFactory sf;

	// ============== 1 : Récupération des catégories

	// Retour d'une liste de toutes les catégories de la BD
	@SuppressWarnings("unchecked")
	public List<Categorie> getAllCategories() {

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Création de la requête HQL
		Query req = s.createQuery("FROM Categorie");

		// Récupération de la liste
		List<Categorie> catOut = req.list();

		// Retour de la liste
		return catOut;
	}

	// Retour d'une catégorie en la cherchant par son Id
	public Categorie getCategoryById(Categorie categorie) {

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Récupération de la catégorie par son id
		Categorie catOut = s.get(Categorie.class, categorie.getIdCategorie());

		// Retour de la catégorie
		return catOut;
	}

	// ============== 2 : Récupération des produits

	// Retour d'une liste de tous les produits de la BD
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProducts() {

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Création de la requête HQL
		Query req = s.createQuery("FROM Produit");

		// Récupération de la liste
		List<Produit> prodOut = req.list();

		// Retour de la liste
		return prodOut;
	}

	// Retour d'une liste de tous les produits d'une catégorie
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProducts(Categorie categorie) {
		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Création de la requête HQL
		Query req = s.createQuery("FROM Produit AS p WHERE p.categorie.id=:pId");

		// Donner l'attribut pId
		req.setParameter("pId", categorie.getIdCategorie());

		// Récupération de la liste
		List<Produit> prodOut = req.list();

		// Retour de la liste
		return prodOut;
	}

	// Retour des produits dont la designation/description contient un mot-clef
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProducts(Produit produit) {
		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Création de la requête HQL
		Query req = s
				.createQuery("FROM Produit AS p WHERE p.designation LIKE %pKeyword% OR p.description LIKE %pKeyword%");

		// Donner l'attribut pId
		req.setParameter("pKeyword", produit.getMotClef());

		// Récupération de la liste
		List<Produit> prodOut = req.list();

		// Retour de la liste
		return prodOut;
	}

	// Retour des produits contenus dans le panier
	public List<Produit> getAllProducts(Panier panier) {

		// Récupération des lignes de commande du panier
		Collection<LigneCommande> lc = panier.getLignecommande();

		// Déclaration et instanciation d'une liste de produits
		List<Produit> lp = new ArrayList<Produit>();

		// Parcour des lignes de commande pour en extraire les produits
		for (LigneCommande l : lc) {
			lp.add(l.getProduit());
		}

		// Retour de la liste de produits
		return lp;
	}

	public Produit getProductById(Produit produit) {
		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Récupération de la catégorie par son id
		Produit prodOut = s.get(Produit.class, produit.getIdProduit());

		// Retour de la catégorie
		return prodOut;

	}

	// ============== 3 : Gestion du panier

	// Ajout d'un produit du panier
	public void addProductToCart(Panier panier, Produit produit, int quantite) {

		// Ajout du produit au panier avec sa quantité
		panier.addProduits(produit, quantite);

	}

	// Suppression d'un produit du panier
	public void removeProductFromCart(Panier panier, Produit produit) {

		// Suppression du produit du panier
		panier.deleteProduit(produit.getIdProduit());
	}

	// ============== 4 : Gestion de la commande

	// Enregistrement de la commande
	public boolean saveOrder(Commande commande) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = commande.getIdCommande();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(commande);

		// Récupérer l'id mis à jour
		idNew = commande.getIdCommande();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

}
