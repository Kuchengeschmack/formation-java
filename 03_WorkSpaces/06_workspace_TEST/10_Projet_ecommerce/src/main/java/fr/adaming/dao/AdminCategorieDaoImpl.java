package fr.adaming.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

// Annotation pour déclarer la classe comme un component Dao
@Repository
public class AdminCategorieDaoImpl extends AdminProduitDaoImpl implements IAdminCategorieDao {

	// ============== 1 : Gestion des catégories

	// Créer une catégorie dans la base de données
	public boolean addCategory(Categorie catIn) {
		// Variables pour vérifier si la commande possède un id
		Long idOld = catIn.getIdCategorie();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(catIn);

		// Récupérer l'id mis à jour
		idNew = catIn.getIdCategorie();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Modifier une catégorie dans la base de données
	public boolean updateCategory(Categorie catIn) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = catIn.getIdCategorie();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(catIn);

		// Récupérer l'id mis à jour
		idNew = catIn.getIdCategorie();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Retour d'une catégorie de la base de données selon son Id
	public Categorie getCategoryById(Categorie catIn) {

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		return s.get(Categorie.class, catIn.getIdCategorie());
	}

	// Suppression d'une catégorie dans la base de données
	public boolean deleteCategory(Categorie catIn) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = catIn.getIdCategorie();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.delete(catIn);

		// Récupérer l'id mis à jour
		idNew = catIn.getIdCategorie();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// ============== 2 : Gestion des clients

	// Ajout d'un client à la base de données
	public boolean addClient(Client client) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = client.getIdClient();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(client);

		// Récupérer l'id mis à jour
		idNew = client.getIdClient();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Modification d'un client à la base de données
	public boolean updateClient(Client client) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = client.getIdClient();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(client);

		// Récupérer l'id mis à jour
		idNew = client.getIdClient();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// ============== 3 : Gestion des admins produit

	// Ajout d'un admin prod
	public boolean addAdminProduct(Admin admin) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(admin);

		// Récupérer l'id mis à jour
		idNew = admin.getIdAdmin();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Modification d'un admin prod
	public boolean updateAdminProduct(Admin admin) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(admin);

		// Récupérer l'id mis à jour
		idNew = admin.getIdAdmin();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// ============== 4 : Gestion des admins catégorie

	// Ajout d'un admin catégorie
	public boolean addAdminCategory(Admin admin) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.save(admin);

		// Récupérer l'id mis à jour
		idNew = admin.getIdAdmin();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

	// Modification d'un admin catégorie
	public boolean updateAdminCategory(Admin admin) {

		// Variables pour vérifier si la commande possède un id
		Long idOld = admin.getIdAdmin();
		Long idNew;

		// Récupération de la session Hibernate
		Session s = sf.getCurrentSession();

		// Sauvergarde de la commande dans le contexte de persistance
		s.update(admin);

		// Récupérer l'id mis à jour
		idNew = admin.getIdAdmin();

		// Si l'id mis à jour est différent de l'ancien id, opération réussie
		if (idNew != idOld) {
			return true;
		}

		// Sinon, opération échouée
		return false;
	}

}
