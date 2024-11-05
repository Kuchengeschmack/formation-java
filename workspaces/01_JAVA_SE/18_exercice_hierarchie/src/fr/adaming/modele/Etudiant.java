package fr.adaming.modele;

import java.util.Scanner;

public class Etudiant extends Scolaire {
	
	private String formation;
	
	// Définir le constructeur
	
	public Etudiant() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Formation : ");
		formation = sc.next();
	}
	
	public Etudiant(String formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Etudiant " + prenom + " " + nom.toUpperCase() + " " + age + " ans. Etablissement : " + nomEtablissement + ", niveau : " + niveau + ", formation : " + formation;
	}

}
