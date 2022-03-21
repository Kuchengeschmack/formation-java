package com.inti;

public class Main {

	public static void main(String[] args) {
		
		Article art1 = new Article(1, "Voiture", 20, 10);
		Article art2 = new Article(2, "Moto", 30, 20);
		Article art3 = new Article(3, "Avion", 40, 5);
		Article art4 = new Article(3, "Avion", 40, 5);
		
		// Le constructeur surchargé fonctionne
		
		System.out.println(art3.equals(art4)); // OK
		
		System.out.println(art1.getReference());
		System.out.println(art2.getIntitule());
		System.out.println(art3.getQuantiteEnStock()); // OK
		
		art3.approvisionner(3);
		
		System.out.println(art3.getQuantiteEnStock()); // OK
		
		art3.vendre(10);
		
		System.out.println(art3.getQuantiteEnStock()); // OK
		
		art3.vendre(7);
		
		System.out.println(art3.getQuantiteEnStock()); // OK
		
		System.out.println(art2.prixHT());	// OK
		System.out.println(art2.prixTTC()); // OK
		
		System.out.println(art1.toString()); // OK
		
	}

}
