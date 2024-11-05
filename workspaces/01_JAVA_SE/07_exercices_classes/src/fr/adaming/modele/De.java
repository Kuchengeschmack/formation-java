package fr.adaming.modele;

import java.util.Random;

public class De {

	// 1----- Attributs
	private int valeur;	// Valeur que sort le dé
	
	// 2----- Constructeurs
	public De() {
		
	}
	
	// 3----- Getters et Setters

	public int getValeur() {
		return valeur;
	}

	// 4----- Méthodes
	public void lancer() {
		Random rand = new Random();
		int maxNumber = 6;
		valeur = rand.nextInt(maxNumber) + 1;
	}


}
