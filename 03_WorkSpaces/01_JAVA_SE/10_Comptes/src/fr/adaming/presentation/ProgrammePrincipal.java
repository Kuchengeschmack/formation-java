package fr.adaming.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import fr.adaming.modele.*;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		
//		// On peut typer les objets de classe filles par la classe mère
//		Personne e3 = new Etudiant();
		
		interfaceHommeMachine();
		
	}
	
	public static void testCompte() {
		
		System.out.println("\nOn test un compte quelconque.\n");
		Compte c1 = new Compte(1, "Dorian", 1000);
		System.out.println(c1.consulterEtatCompte());
		c1.deposerArgent(10);
		System.out.println(c1.consulterEtatCompte());
		c1.retirerArgent(1020);
		System.out.println(c1.consulterEtatCompte());
		c1.retirerArgent(30);
		System.out.println(c1.consulterEtatCompte());
		
	}
	
	public static void testCompteEpargne() {
		// test de la classe CompteEpargne
		
		System.out.println("\nOn passe au compte épargne.\n");
		
		CompteEpargne.taux = 0.02; // 2% d'intéret pour tous les comptes épargne
				
		CompteEpargne c2 = new CompteEpargne(2, "Dorian", 1000);
		System.out.println(c2.consulterEtatCompte());
		c2.deposerArgent(10);
		System.out.println(c2.consulterEtatCompte());
		c2.retirerArgent(1020);
		System.out.println(c2.consulterEtatCompte());
		c2.retirerArgent(30);
		System.out.println(c2.consulterEtatCompte());
		System.out.println(c2.calculInteretsAcquis()); // Affiche et calcule les intérêts acquis
		System.out.println(c2.consulterEtatCompte()); // Affiche le solde actualisé avec les intérets
	}
	
	public static void testCompteCourant() {
		// test de la classe CompteCourant
		
		System.out.println("\nOn passe au compte courant.\n");
		
		CompteCourant.decouvertAutorise = 100; // 100€ de découvert autorisé
				
		CompteCourant c3 = new CompteCourant(3, "Dorian", 1000);
		System.out.println(c3.consulterEtatCompte());
		c3.deposerArgent(10);
		System.out.println(c3.consulterEtatCompte());
		// On retire plus d'argent qu'il n'y a sur le compte, dans la limite du découvert autorisé
		c3.retirerArgent(1020);
		System.out.println(c3.consulterEtatCompte());
		// On retire encore de l'argent afin d'aller au-delà du découvert
		c3.retirerArgent(200);
		System.out.println(c3.consulterEtatCompte());
		
		System.out.println(c3);
	}

	public static void interfaceHommeMachine() {
		
		int typeCompte = 0;
		int poursuivre = 0;
		ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		int numeroCompte = 0; // Permet d'indexer les comptes
		String nomTitulaire = new String();
		CompteEpargne.taux = 0.07; // Il faut investir dans le bitcoin !
		CompteCourant.decouvertAutorise = 100;
		int choixCompte = -1;
		double montant; // Montant à déposer où à retirer du compte
		
		// Initialiser les taux d'intérêt et de découvert autorisé
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Quelle opération souhaitez-vous faire ? 1 : ouvrir compte courant, 2 : ouvrir compte épargne, 3 : retirer argent, 4 : déposer argent ");
	
			do {
				typeCompte = sc.nextInt();
			} while (typeCompte < 0 || typeCompte > 4);
			
			switch (typeCompte) {
			case 1:
				System.out.println("Vous avez choisi un compte courant.\nNom du titulaire : ");
				nomTitulaire = sc.next();
				listeCompte.add(new CompteCourant(numeroCompte++, nomTitulaire, 0));
				break;
			case 2:
				System.out.println("Vous avez choisi un compte épargne.\nNom du titulaire : ");
				nomTitulaire = sc.next();
				listeCompte.add(new CompteEpargne(numeroCompte++, nomTitulaire , 0));
				break;
			case 3:
				System.out.println("Vous avez choisi de retirer de l\'argent. Veuillez renseigner le numéro du compte : ");
				choixCompte = sc.nextInt();
				System.out.println("Veuillez renseigner un montant : ");
				montant = sc.nextDouble();
				for(Compte c : listeCompte) {
					if (c.getNumero() == choixCompte) {
						c.retirerArgent(montant);
					}
				}
				break;
			case 4:
				System.out.println("Vous avez choisi de déposer de l\'argent. Veuillez renseigner le numéro du compte : ");
				choixCompte = sc.nextInt();
				System.out.println("Veuillez renseigner un montant : ");
				montant = sc.nextDouble();
				for(Compte c : listeCompte) {
					if (c.getNumero() == choixCompte) {
						c.deposerArgent(montant);
						}
					}
				break;
			default:
				
				}
			
			System.out.println();
			
			System.out.println("--------------------------------------\nVoici la liste des comptes existants : \n");
			System.out.println("N°\tType\tNom\tSolde");
			
			for(Compte c : listeCompte) {
				System.out.println(c.toString());
			}
			
			System.out.println("--------------------------------------\n");
			
			System.out.println("Souhaitez-vous faire une nouvelle opération ? 1 : nouvelle opération, 2 : quitter ");
			poursuivre = sc.nextInt();
		
		} while (poursuivre == 1); // Tant que l'utilisateur souhaite créer un nouveau compte
		
		
	}
}
