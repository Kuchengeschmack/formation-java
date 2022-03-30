package fr.adaming.service;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;

public interface IAdminProduitService {

	// ============== Gestion des produits

	// Créer un produit dans la base de données
	public boolean addProduct(Produit prodIn, Categorie catIn);

	// Modifier un produit dans la base de données
	public boolean updateProduct(Produit prodIn);

	// Retour d'un produit de la base de données selon son Id
	public Produit getProductById(Produit prodIn);

	// Suppression d'un produit dans le base de données
	public boolean deleteProduct(Produit prodIn);
}
