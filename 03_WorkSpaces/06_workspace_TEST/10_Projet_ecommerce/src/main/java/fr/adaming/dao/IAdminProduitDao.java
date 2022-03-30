package fr.adaming.dao;

import fr.adaming.entities.Produit;

/*
 * Définit les méthodes propres aux
 * admin produits
 */

public interface IAdminProduitDao {

	// ============== Gestion des produits

	// Créer un produit dans la base de données
	public boolean addProduct(Produit prodIn);

	// Modifier un produit dans la base de données
	public boolean updateProduct(Produit prodIn);

	// Retour d'un produit de la base de données selon son Id
	public Produit getProductById(Produit prodIn);

	// Suppression d'un produit dans le base de données
	public boolean deleteProduct(Produit prodIn);

}
