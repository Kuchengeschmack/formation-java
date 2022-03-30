package fr.adaming.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier {

	// Déclaration des attributs

	/*
	 * On a besoin d'une collection pour le panier On peut partir sur une collection
	 * non pas "list" mais "map" de sorte à retrouver le produit par sa reference et
	 * son idProduit
	 */

	private int nbrProduit;
	private double total;

	// Transformation de l'association UML en Java
	// Map<"letype", "objet/collection">
	private Map<Long, LigneCommande> a = new HashMap<Long, LigneCommande>();

	// Déclaration des constructeurs

	public Panier() {
		super();
	}

	public Panier(Map<Long, LigneCommande> a) {
		super();
		this.a = a;
	}

	// Déclaration des getters et des setters

	public Map<Long, LigneCommande> getA() {
		return a;
	}

	public void setA(Map<Long, LigneCommande> a) {
		this.a = a;
	}

	// Déclaration des autres méthodes

	// 1---On ajoute des methodes ici on ajoute un produit/sinon on ajoute
	// LigneCommande si pas produit

	// 1---On ajoute des methodes ici on ajoute un produit/sinon on ajoute
	// LigneCommande si pas produit

	public void addProduits(Produit produit, int quantite) {

		// si on ne recupere pas de IdProduit alors on cree la LigneCommande
		// = "Si le produit n'est pas déjà présent dans une ligne de commande du panier"
		if (a.get(produit.getIdProduit()) == null) {
			LigneCommande lignecommande = new LigneCommande();

			// def et de la LigneCommande avec produit/quantite/prix

			lignecommande.setProduit(produit);
			lignecommande.setPrix(produit.getPrix());
			lignecommande.setQuantite(quantite);

			// on recupere la LigneCommande et on modifie la quantite/C'est pour que sur
			// l'application on puisse modifier la quantite dans le panier

		} else {
			LigneCommande lignecommande = a.get(produit.getIdProduit());
			lignecommande.setQuantite(lignecommande.getQuantite() + quantite);
		}
	}

	// 2----- methode pour connaitre le total du panier(le calculer)

	public double getTotal() {

		// initialisation du para total
		total = 0;

		// la boucle et le compteur
		for (LigneCommande lignecommande : a.values()) {

			// le compteur
			total += lignecommande.getPrix() * lignecommande.getQuantite();

		}
		return total;
	}

	// 3-----methode pour connaitre le nbre de produit dans le panier

	public int getNbrProduit() {

		nbrProduit = a.size();
		return nbrProduit;

	}

	// 4----methode pour supprimer un produit du panier

	public void deleteProduit(Long idProduit) {

		a.remove(idProduit);

	}

	// 5---methode pour consulter les ligneCommande

	public Collection<LigneCommande> getLignecommande() {

		return a.values();
	}

}
