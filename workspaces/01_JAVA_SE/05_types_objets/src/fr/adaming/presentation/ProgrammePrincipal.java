package fr.adaming.presentation;

import fr.adaming.modele.Personne;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// D�claration d'une variable de type Personne
		Personne p1;
		
		// Instancier l'objet p1 (cr�er cet objet concr�tement dans la m�moire)
		// gr�ce � l'op�rateur new et le constructeur de la classe
		p1 = new Personne();

		// appel de la m�thode afficherInfos de p1
		p1.afficherInfos();
		
		// modifier les valeurs des attributs public de l'objet p1
		p1.setNom("TOTO");
		p1.prenom = "Titi";
		p1.setAge(26);
		
		p1.afficherInfos();
		
		// lire les valeurs des attributs publics de l'objet p1
		System.out.println("le nom de p1 est : " + p1.getNom());
		
		// Utilisation du constructeur surcharg�
		Personne p2;
		p2 = new Personne("Dorian");
		
	}

}
