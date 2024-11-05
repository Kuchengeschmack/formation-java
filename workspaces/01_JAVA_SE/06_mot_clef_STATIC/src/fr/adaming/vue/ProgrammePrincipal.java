package fr.adaming.vue;

import fr.adaming.modele.Etudiant;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Déclaration et instanciation d'un objet p1 de type Etudiant
		Etudiant e1 = new Etudiant();
		
		System.out.println("La valeur du compteur de e1 est : " + e1.getCompteur());
		
		// Déclaration et instanciation d'un objet e2 de type Etudiant
		Etudiant e2 = new Etudiant("TOTO", "Titi");
		System.out.println("\nLa valeur du compteur de e2 est : " + e2.getCompteur());
		System.out.println("La valeur du compteur de e1 est : " + e1.getCompteur());
		
		// appel d'une méthode non statique d'un objet
		e2.manger();
		
		Etudiant.reviser(); // Une méthode de classe doit être accédée par sa classe
	}

}
