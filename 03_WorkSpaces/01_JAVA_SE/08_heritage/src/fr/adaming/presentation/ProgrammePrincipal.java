package fr.adaming.presentation;

import fr.adaming.modele.*;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		
		// Déclaration et instanciation d'un objet de type Etudiant
		Etudiant e1 = new Etudiant("TOTO", "Titi", 23, "cursus");
		String infos = e1.afficherInfos();
		System.out.println(infos);
		
		// Appel des méthodes de e1 héritées de Personne
		e1.marcher();
		e1.manger();
		
		e1.reviser("TOTO", 25.2);
		
		
	}

}
