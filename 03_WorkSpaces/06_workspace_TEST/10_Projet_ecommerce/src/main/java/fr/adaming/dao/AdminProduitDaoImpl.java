package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Produit;

//Annotation pour déclarer la classe comme un component Dao
@Repository
public class AdminProduitDaoImpl implements IAdminProduitDao {

	@Autowired
	protected SessionFactory sf; // protected afin d'hériter la SessionFactory dans AdminCategorieDaoImpl

	// ============== Gestion des produits

	// Créer un produit dans la base de données
	public boolean addProduct(Produit prodIn) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = prodIn.getIdProduit();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(prodIn);

		// Récupérer l'id mis à jour
		idNew = prodIn.getIdProduit();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Modifier un produit dans la base de données
	public boolean updateProduct(Produit prodIn) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = prodIn.getIdProduit();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(prodIn);

		// Récupérer l'id mis à jour
		idNew = prodIn.getIdProduit();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Retour d'un produit de la base de données selon son Id
	public Produit getProductById(Produit prodIn) {

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		return s.get(Produit.class, prodIn.getIdProduit());
	}

	// Suppression d'un produit dans le base de données
	public boolean deleteProduct(Produit prodIn) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = prodIn.getIdProduit();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.delete(prodIn);

		// Récupérer l'id mis à jour
		idNew = prodIn.getIdProduit();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

}
