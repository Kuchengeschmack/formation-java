package fr.adaming.presentation;

import java.util.List;
import java.util.Scanner;

import fr.adaming.modele.Etudiant;
import fr.adaming.service.EtudiantServiceImpl;
import fr.adaming.service.IEtudiantService;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Transformation d l'association UML en JAVA
		IEtudiantService eService = new EtudiantServiceImpl();

		// Instanciation d'un objet Scanner
		Scanner sc = new Scanner(System.in);

		String choix = "non";

		do {
			System.out.println("Choisir une op�rtion : ");
			System.out.println("\t1- Ajouter");
			System.out.println("\t2- Modifier");
			System.out.println("\t3- Supprimer");
			System.out.println("\t4- Afficher la liste");
			System.out.println("\t5- Rechercher un �tudiant");

			int op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Entrer le nom : ");
				String nom = sc.nextLine();

				System.out.println("Enter le pr�nom : ");
				String prenom = sc.nextLine();

				System.out.println("Enter l'�ge : ");
				int age = sc.nextInt();
				sc.nextLine(); // Pourquoi ?

				// Instancier un �tudiat avec ces valeurs
				Etudiant e1 = new Etudiant(nom, prenom, age);

				// Appel de la m�thode de la couche service
				eService.addEtudiantService(e1);

				break;

			case 2:
				System.out.println("Entrer l'id de l'�tudiant � modifier : ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("Entrer le nom : ");
				nom = sc.nextLine();

				System.out.println("Enter le pr�nom : ");
				prenom = sc.nextLine();

				System.out.println("Enter l'�ge : ");
				age = sc.nextInt();
				sc.nextLine(); // Pourquoi ?

				// Instancier un �tudiat avec ces valeurs
				Etudiant eModif = new Etudiant(id, nom, prenom, age);

				// Appel de la m�thode de la couche service
				int verif = eService.updateEtudiantService(eModif);

				if (verif != 0) {
					System.out.println("----- La modif est OK");
				} else {
					System.out.println("----- La modif est KO!");
				}

				break;

			case 3:
				System.out.println("Entrer l'id de l'�tudiant � supprimer : ");
				id = sc.nextInt();
				sc.nextLine();

				// Appel de la m�thode de la couche service
				verif = eService.deleteEtudiantService(id);

				if (verif != 0) {
					System.out.println("----- La suppression est OK");
				} else {
					System.out.println("----- La suppression est KO!");
				}
				break;

			case 4:
				List<Etudiant> liste = eService.getAllEtudiantsService();

				for (Etudiant e : liste) {
					System.out.println(e);
				}

				break;

			case 5:
				System.out.println("Entrer l'id de l'�tudiant � chercher : ");
				id = sc.nextInt();
				sc.nextLine();

				// Appel de la m�thode couche service
				Etudiant eOut = eService.getEtudiantService(id);
				System.out.println(eOut);

				break;

			default:
				System.out.println("Il faut choisir le bonne op�ration");

			}
			System.out.println("Voulez-vous quitter (oui/non)?");
			choix = sc.nextLine();

		} while (!choix.equals("oui"));

//		// Fonctionalit� AJOUTER
//		Etudiant e1 = new Etudiant("TOTO", "Titi", 26);
//		eService.addEtudiantService(e1);

//		// Fonctionalit� MODIFIER
//		Etudiant e2 = new Etudiant(1, "RORO", "Riri", 28);		
//		// Appel de la m�thode couche service
//		int verif = eService.updateEtudiantService(e2);
//		if(verif!=0) {
//			System.out.println("----- La modif est OK");
//		} else {
//			System.out.println("----- La modif est KO!");
//		}

//		// Fonctionalit� DELETE
//		int verif = eService.deleteEtudiantService(1);
//		if (verif != 0) {
//			System.out.println("----- Le delete est OK");
//		} else {
//			System.out.println("----- Le delete est KO!");
//		}

//		 Fonctionalit� afficher la liste
//		List<Etudiant> liste = eService.getAllEtudiantsService();
//
//		for (Etudiant e : liste) {
//			System.out.println(e);
//		}

		// Fonctionalit� afficher �tudiant
//		Etudiant e = eService.getEtudiantService(8);
//		System.out.println(e);

	}

}
