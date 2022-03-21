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
			System.out.println("Choisir une opértion : ");
			System.out.println("\t1- Ajouter");
			System.out.println("\t2- Modifier");
			System.out.println("\t3- Supprimer");
			System.out.println("\t4- Afficher la liste");
			System.out.println("\t5- Rechercher un étudiant");

			int op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Entrer le nom : ");
				String nom = sc.nextLine();

				System.out.println("Enter le prénom : ");
				String prenom = sc.nextLine();

				System.out.println("Enter l'âge : ");
				int age = sc.nextInt();
				sc.nextLine(); // Pourquoi ?

				// Instancier un étudiat avec ces valeurs
				Etudiant e1 = new Etudiant(nom, prenom, age);

				// Appel de la méthode de la couche service
				eService.addEtudiantService(e1);

				break;

			case 2:
				System.out.println("Entrer l'id de l'étudiant à modifier : ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("Entrer le nom : ");
				nom = sc.nextLine();

				System.out.println("Enter le prénom : ");
				prenom = sc.nextLine();

				System.out.println("Enter l'âge : ");
				age = sc.nextInt();
				sc.nextLine(); // Pourquoi ?

				// Instancier un étudiat avec ces valeurs
				Etudiant eModif = new Etudiant(id, nom, prenom, age);

				// Appel de la méthode de la couche service
				int verif = eService.updateEtudiantService(eModif);

				if (verif != 0) {
					System.out.println("----- La modif est OK");
				} else {
					System.out.println("----- La modif est KO!");
				}

				break;

			case 3:
				System.out.println("Entrer l'id de l'étudiant à supprimer : ");
				id = sc.nextInt();
				sc.nextLine();

				// Appel de la méthode de la couche service
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
				System.out.println("Entrer l'id de l'étudiant à chercher : ");
				id = sc.nextInt();
				sc.nextLine();

				// Appel de la méthode couche service
				Etudiant eOut = eService.getEtudiantService(id);
				System.out.println(eOut);

				break;

			default:
				System.out.println("Il faut choisir le bonne opération");

			}
			System.out.println("Voulez-vous quitter (oui/non)?");
			choix = sc.nextLine();

		} while (!choix.equals("oui"));

//		// Fonctionalité AJOUTER
//		Etudiant e1 = new Etudiant("TOTO", "Titi", 26);
//		eService.addEtudiantService(e1);

//		// Fonctionalité MODIFIER
//		Etudiant e2 = new Etudiant(1, "RORO", "Riri", 28);		
//		// Appel de la méthode couche service
//		int verif = eService.updateEtudiantService(e2);
//		if(verif!=0) {
//			System.out.println("----- La modif est OK");
//		} else {
//			System.out.println("----- La modif est KO!");
//		}

//		// Fonctionalité DELETE
//		int verif = eService.deleteEtudiantService(1);
//		if (verif != 0) {
//			System.out.println("----- Le delete est OK");
//		} else {
//			System.out.println("----- Le delete est KO!");
//		}

//		 Fonctionalité afficher la liste
//		List<Etudiant> liste = eService.getAllEtudiantsService();
//
//		for (Etudiant e : liste) {
//			System.out.println(e);
//		}

		// Fonctionalité afficher étudiant
//		Etudiant e = eService.getEtudiantService(8);
//		System.out.println(e);

	}

}
