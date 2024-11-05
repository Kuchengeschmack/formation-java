package fr.adaming.modele;

import java.util.Scanner;

public class Lyceen extends Scolaire {

	private String bac;
	
	// Définir les constructeurs
	
	public Lyceen() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bac (S/ES/L) : ");
		bac = sc.next();
		
		if(bac.equals("ES") || bac.equals("L") || bac.equals("S")) {
			this.bac = bac;
		} else {
			this.bac = null;
		}
	}
	
	public Lyceen(String bac) {
		
		if(bac.equals("ES") || bac.equals("L") || bac.equals("S")) {
			this.bac = bac;
		} else {
			this.bac = null;
		}
		
	}

	@Override
	public String toString() {
		return "Lyceen " + prenom + " " + nom.toUpperCase() + " " + age + " ans. Etablissement : " + nomEtablissement + ", niveau : " + niveau + ", bac : " + bac;
	}
}
     