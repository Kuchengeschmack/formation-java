package fr.adaming.service;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

public interface IAdminCategorieService {

	// ============== 1 : Gestion des catégories

	// Créer une catégorie dans la base de données
	public boolean addCategory(Categorie catIn);

	// Modifier une catégorie dans la base de données
	public boolean updateCategory(Categorie catIn);

	// Retour d'une catégorie de la base de données selon son Id
	public Categorie getCategoryById(Categorie catIn);

	// Suppression d'une catégorie dans la base de données
	public boolean deleteCategory(Categorie catIn);

	// ============== 2 : Gestion des clients

	// Ajout d'un client à la base de données
	public boolean addClient(Client client);

	// Modification d'un client à la base de données
	public boolean updateClient(Client client);

	// ============== 3 : Gestion des admins produit

	// Ajout d'un admin prod
	public boolean addAdminProduct(Admin admin);

	// Modification d'un admin prod
	public boolean updateAdminProduct(Admin admin);

	// ============== 4 : Gestion des admins catégorie

	// Ajout d'un admin catégorie
	public boolean addAdminCategory(Admin admin);

	// Modification d'un admin catégorie
	public boolean updateAdminCategory(Admin admin);
}
