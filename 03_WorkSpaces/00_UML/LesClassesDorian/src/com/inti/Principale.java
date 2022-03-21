package com.inti;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Voiture v1 = new Voiture(1, "Peugeot", 15999.99);
		Voiture v2 = new Voiture(1, "Mercedes", 14599.99);
		
		System.out.println("Prix : " + v1.getPrix());
		System.out.println("Prix : " + v2.getPrix());
		
		v1.setPrix(13299.25);
		
		System.out.println("Prix : " + v1.getPrix());
		System.out.println("Prix : " + v2.getPrix());
		
		Voiture v3 = new Voiture(); // C'est une voiture vide car on appelle le constructeur vide
		v3.setNumSerie(3);
		v3.setMarque("Renault");
		v3.setPrix(11999.99);
		
		System.out.println("Prix " + v3.getMarque() + " : "+ v3.getPrix());
		
		Voiture v4 = new Voiture(2, "Lancia");
		v4.setPrix(10258.69);
		
		v4.promotion(10, true);
		
		System.out.println("Prix v4 avec promo : " + v4.getPrix());
		
	}

}
