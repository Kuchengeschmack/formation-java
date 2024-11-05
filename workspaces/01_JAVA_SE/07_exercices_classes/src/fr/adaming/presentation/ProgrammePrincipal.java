package fr.adaming.presentation;

import fr.adaming.modele.*;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Exercice sur les polyn�mes
		//exEquations();
		
		// Exercice sur l'extraction des voyelles et des consonnes
		exVoyellesConsonnes();

		// Exercice sur les d�s
		//exDes();
		
		}
	
	public static void exEquations() {
		
		// Test avec un polyn�me valide
		Equation p = new Equation(1, -1, -1);	// Doit retourner le nombre d'or et le nombre d'or - 1
		p.afficherRacines();
		
		// Test avec a = 0
		Equation p2 = new Equation(0, -1, -1);	// Doit afficher qu'il ne s'agit pas d'un polyn�me
		p2.afficherRacines();
		
		// Test avec un polyn�me � racines complexes
		Equation p3 = new Equation(1, 1, 1);	// Doit afficher qu'il ne s'agit pas d'un polyn�me
		p3.afficherRacines();
		
	}

	public static void exVoyellesConsonnes() {
		
		Chaine1 ch = new Chaine1("Je suis Thierry Beccaro !");
		ch.extraction();
		System.out.println(ch.getStr());
		System.out.println(ch.getVoy());
		System.out.println(ch.getCon());
		
	}
	
	public static void exDes() {
		
		// Instanciation des d�s
		De de1 = new De();
		De de2 = new De();
		De de3 = new De();
		
		// Lancers des d�s
		de1.lancer();
		de2.lancer();
		de3.lancer();
		
		// Afficher les r�sultats des d�s
		System.out.println(de1.getValeur());
		System.out.println(de2.getValeur());
		System.out.println(de3.getValeur());
		
		// Si au moins deux d�s donnent la m�me valeur, c'est gagn� !
		if(de1.getValeur() == de2.getValeur() || de1.getValeur() == de3.getValeur() || de2.getValeur() == de3.getValeur()) {
			System.out.println("Oh ouiouioui c\'est gagn� ! Je suis Julien Lepers !");
		} else {
			System.out.println("C\'est perdu, il faut se resaisir Michel !");
		}
		
	}
}
