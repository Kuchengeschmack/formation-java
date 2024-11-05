package fr.adaming.presentation;

import fr.adaming.modele.Mairie;
import fr.adaming.modele.Personne;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		
		Mairie m1 = new Mairie("Deux-Verges"); // Oui, cette ville existe (Cantal, 15)

		Personne p1 = new Personne("Jean", "Bon");
		Personne p2 = new Personne("Jeannette", "Bonnette");
		
		System.out.println(m1.marier(p1, p2).toString());
	}

}
