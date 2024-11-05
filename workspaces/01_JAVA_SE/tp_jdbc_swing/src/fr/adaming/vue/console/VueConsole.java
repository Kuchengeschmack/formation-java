package fr.adaming.vue.console;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.adaming.modele.Client;
import fr.adaming.modele.Compte;
import fr.adaming.modele.CompteCourant;
import fr.adaming.modele.CompteEpargne;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

public class VueConsole {

	public static void lancerConsole() {
		// Transformation d l'association UML en JAVA
		IClientService clientService = new ClientServiceImpl(); // Instanciation d'un objet service Client
		ICompteService courantService = new CompteCourantServiceImpl(); // Instanciation d'un objet service compte
		ICompteService epargneService = new CompteEpargneServiceImpl(); // Instanciation d'un objet service compte

		// D�claration des variables et objets utilis�s par l'interface des choix et des
		// objets services
		Scanner sc = new Scanner(System.in);

		String choix = "non";
		int catOp;
		int op;
		int verif; // Pour v�rifier les retours de m�thodes
		boolean verifBool; // Pour v�rifier les virements

		Client client;

		String nom;
		String prenom;
		String adresse;
		int codePostal;
		String ville;
		int numTelephone;
		List<Client> listeClient;

		CompteCourant cc;
		CompteEpargne ce;
		int numDebit;
		int numCredit;

		int numCompte;
		Double solde; // En SQL, les tables compte_courant et compte_epargne poss�dent un champ
		int numClient; // 'num_client'
		Double montant;
		List<Compte> listeCompte;

		do {
			try {
				System.out.println("Choisir une cat�gorie d'op�ration : ");
				System.out.println("\t1- Client");
				System.out.println("\t2- Compte courant");
				System.out.println("\t3- Compte �pargne");

				catOp = sc.nextInt();
				sc.nextLine(); // Retour chariot apr�s l'acquisition de l'int
				switch (catOp) {

				// Op�ration sur un client
				case 1:
					System.out.println("Choisir une op�ration : ");
					System.out.println("\t1- Ajouter un client");
					System.out.println("\t2- Supprimer un client");
					System.out.println("\t3- Modifier un client");
					System.out.println("\t4- Afficher tous les clients");
					System.out.println("\t5- Chercher un client par son num�ro de client");

					op = sc.nextInt();
					sc.nextLine(); // Retour chariot apr�s l'acquisition de l'int

					switch (op) {
					case 1:
						System.out.println("Saisir le nom : ");
						nom = sc.nextLine();
						System.out.println("Saisir le pr�nom : ");
						prenom = sc.nextLine();
						System.out.println("Saisir l'adresse : ");
						adresse = sc.nextLine();
						System.out.println("Saisir le code postal : ");
						codePostal = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir la ville : ");
						ville = sc.nextLine();
						System.out.println("Saisir le num�ro de t�l�phone : ");
						numTelephone = sc.nextInt();
						sc.nextLine();

						client = new Client(nom, prenom, adresse, codePostal, ville, numTelephone);

						verif = clientService.ajouterClientService(client);
						if (verif != 0) {
							System.out.println("\n---- Le client a bien �t� ajout�.\n");
						} else {
							System.out.println("\n---- Echec de l'ajout du client.\n");
						}

						break;
					case 2:
						System.out.println("Saisir le num�ro du client � supprimer : ");
						numClient = sc.nextInt();
						sc.nextLine();
						verif = clientService.supprimerClientService(numClient);
						if (verif != 0) {
							System.out.println("\n---- Le client a bien �t� supprim�.\n");
						} else {
							System.out.println("\n---- Echec de la suppression du client.\n");
						}

						break;
					case 3:
						System.out.println("Saisir le num�ro du client � modifier : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le nom : ");
						nom = sc.nextLine();
						System.out.println("Saisir le pr�nom : ");
						prenom = sc.nextLine();
						System.out.println("Saisir l'adresse : ");
						adresse = sc.nextLine();
						System.out.println("Saisir le code postal : ");
						codePostal = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir la ville : ");
						ville = sc.nextLine();
						System.out.println("Saisir le num�ro de t�l�phone : ");
						numTelephone = sc.nextInt();
						sc.nextLine();

						client = new Client(numClient, nom, prenom, adresse, codePostal, ville, numTelephone);

						verif = clientService.modifierClientService(client);
						if (verif != 0) {
							System.out.println("\n---- Le client a bien �t� modifi�.\n");
						} else {
							System.out.println("\n---- Echec de la modification du client.\n");
						}

						break;
					case 4:
						listeClient = clientService.getAllClientService();
						if (listeClient.size() > 0) {
							for (Client c : listeClient) {
								System.out.println(c);
							}
						} else {
							System.out.println("\n---- La base de donn�es client est vide.\n");
						}

						break;
					case 5:
						System.out.println("Saisir le num�ro du client � rechercher : ");
						numClient = sc.nextInt();
						sc.nextLine();
						client = clientService.chercherClientService(numClient);
						if (client != null) {
							System.out.println(client);
						} else {
							System.out.println("\n---- Le client recherch� n'existe pas dans la base de donn�es.\n");
						}

						break;
					default:
						System.out.println("\n---- Il faut choisir la bonne op�ration.\n");

					}

					break;

				// Op�ration sur un compte courant
				case 2:
					System.out.println("Choisir une op�ration : ");
					System.out.println("\t1- Ajouter un compte courant");
					System.out.println("\t2- Supprimer un compte courant");
					System.out.println("\t3- Modifier un compte courant");
					System.out.println("\t4- Afficher tous les comptes courants");
					System.out.println("\t5- Chercher un compte courant par son num�ro de compte");
					System.out.println("\t6- Chercher un compte courant par son num�ro de client");
					System.out.println("\t7- Retirer de l'argent d'un compte courant");
					System.out.println("\t8- D�poser de l'argent sur un compte courant");
					System.out.println("\t9- R�aliser un virement d'un compte courant � un autre compte courant");

					op = sc.nextInt();
					sc.nextLine(); // Retour chariot apr�s l'acquisition de l'int

					switch (op) {
					case 1:
						System.out.println("Saisir le num�ro de compte : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le num�ro de client du propri�taire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						cc = new CompteCourant(numCompte, solde, numClient);
						verif = courantService.attribuerCompteService(cc);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien �t� cr�� et attribu�.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu �tre cr��.\n");
						}

						break;
					case 2:
						System.out.println("Saisir le num�ro de compte � supprimer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						verif = courantService.supprimerCompteService(numCompte);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien �t� supprim�.\n");
						} else {
							System.out.println("\n----- Le compte n'a pas pu �tre supprim�.\n");
						}

						break;
					case 3:
						System.out.println("Saisir le num�ro de compte � modifier : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le num�ro de client du propri�taire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						cc = new CompteCourant(numCompte, solde, numClient);
						verif = courantService.modifierCompteService(cc);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien �t� modifi�.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu �tre modifi�.\n");
						}

						break;
					case 4:
						listeCompte = courantService.getAllCompteService();

						if (listeCompte.size() > 0) {
							for (Compte c : listeCompte) {
								System.out.println(c);
							}
						} else {
							System.out.println("\n---- Il n'existe aucun compte dans la base de donn�es.\n");
						}

						break;
					case 5:
						System.out.println("Saisir le num�ro de compte � rechercher : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						Compte c = courantService.chercherIdCompteService(numCompte);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherch� n'existe pas dans la base de donn�es.\n");
						}

						break;
					case 6:
						System.out.println("Saisir le num�ro de client du compte � rechercher : ");
						numClient = sc.nextInt();
						sc.nextLine();
						c = courantService.chercherIdClientCompteService(numClient);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherch� n'existe pas dans la base de donn�es.\n");
						}

						break;
					case 7:
						System.out.println("Saisir le num�ro de compte duquel retirer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant � retirer : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = courantService.retirerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le retrait a bien �t� effectu�.\n");
						} else {
							System.out.println("\n---- Le retrait n'a pas pu �tre effectu�.\n");
						}

						break;
					case 8:
						System.out.println("Saisir le num�ro de compte sur lequel d�poser : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant � d�poser : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = courantService.deposerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le d�p�t a bien �t� effectu�.\n");
						} else {
							System.out.println("\n---- Le d�p�t n'a pas pu �tre effectu�.\n");
						}

						break;
					case 9:
						System.out.println("Saisir le num�ro de compte � d�biter : ");
						numDebit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le num�ro de compte � cr�diter : ");
						numCredit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisissez le montant � virer : ");
						montant = sc.nextDouble();
						sc.nextLine();
						verifBool = courantService.virerCompteService(numDebit, numCredit, montant);
						if (verifBool) {
							System.out.println("\n---- Le virement a bien �t� effectu�.\n");
						} else {
							System.out.println("\n---- Le virement n'a pas pu �tre effectu�.\n");
						}

						break;
					default:
						System.out.println("\n---- Il faut choisir la bonne op�ration.\n");
					}

					break;

				// Op�ration sur un compte �pargne
				case 3:
					System.out.println("Choisir une op�ration : ");
					System.out.println("\t1- Ajouter un compte �pargne");
					System.out.println("\t2- Supprimer un compte �pargne");
					System.out.println("\t3- Modifier un compte �pargne");
					System.out.println("\t4- Afficher tous les comptes �pargne");
					System.out.println("\t5- Chercher un compte �pargne par son num�ro de compte");
					System.out.println("\t6- Chercher un compte �pargne par son num�ro de client");
					System.out.println("\t7- Retirer de l'argent d'un compte �pargne");
					System.out.println("\t8- D�poser de l'argent sur un compte �pargne");
					System.out.println("\t9- R�aliser un virement d'un compte �pargne � un autre compte �pargne");

					op = sc.nextInt();
					sc.nextLine(); // Retour chariot apr�s l'acquisition de l'int

					switch (op) {
					case 1:
						System.out.println("Saisir le num�ro de compte : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le num�ro de client du propri�taire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						ce = new CompteEpargne(numCompte, solde, numClient);
						verif = epargneService.attribuerCompteService(ce);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien �t� cr�� et attribu�.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu �tre cr��.\n");
						}

						break;
					case 2:
						System.out.println("Saisir le num�ro de compte � supprimer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						verif = epargneService.supprimerCompteService(numCompte);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien �t� supprim�.\n");
						} else {
							System.out.println("\n----- Le compte n'a pas pu �tre supprim�.\n");
						}

						break;
					case 3:
						System.out.println("Saisir le num�ro de compte � modifier : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le num�ro de client du propri�taire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						ce = new CompteEpargne(numCompte, solde, numClient);
						verif = epargneService.modifierCompteService(ce);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien �t� modifi�.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu �tre modifi�.\n");
						}
						break;
					case 4:
						listeCompte = epargneService.getAllCompteService();
						if (listeCompte.size() > 0) {
							for (Compte c : listeCompte) {
								System.out.println(c);
							}
						} else {
							System.out.println("\n---- Il n'existe aucun compte dans la base de donn�es.\n");
						}

						break;
					case 5:
						System.out.println("Saisir le num�ro de compte � rechercher : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						Compte c = epargneService.chercherIdCompteService(numCompte);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherch� n'existe pas dans la base de donn�es.\n");
						}
						break;
					case 6:
						System.out.println("Saisir le num�ro de client du compte � rechercher : ");
						numClient = sc.nextInt();
						sc.nextLine();
						c = epargneService.chercherIdClientCompteService(numClient);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherch� n'existe pas dans la base de donn�es.\n");
						}
						break;
					case 7:
						System.out.println("Saisir le num�ro de compte duquel retirer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant � retirer : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = epargneService.retirerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le retrait a bien �t� effectu�.\n");
						} else {
							System.out.println("\n---- Le retrait n'a pas pu �tre effectu�.\n");
						}

						break;
					case 8:
						System.out.println("Saisir le num�ro de compte sur lequel d�poser : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant � d�poser : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = epargneService.deposerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le d�p�t a bien �t� effectu�.\n");
						} else {
							System.out.println("\n---- Le d�p�t n'a pas pu �tre effectu�.\n");
						}
						break;
					case 9:
						System.out.println("Saisir le num�ro de compte � d�biter : ");
						numDebit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le num�ro de compte � cr�diter : ");
						numCredit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisissez le montant � virer : ");
						montant = sc.nextDouble();
						sc.nextLine();
						verifBool = epargneService.virerCompteService(numDebit, numCredit, montant);
						if (verifBool) {
							System.out.println("\n---- Le virement a bien �t� effectu�.\n");
						} else {
							System.out.println("\n---- Le virement n'a pas pu �tre effectu�.\n");
						}
						break;

					default:
						System.out.println("\n---- Il faut choisir la bonne op�ration.\n");
					}

					break;

				default:
					System.out.println("\n---- Il faut choisir la bonne op�ration.\n");

				}
			} catch (InputMismatchException e) {
				System.out.println("\n---- Il faut choisir la bonne op�ration.\n");
				sc.nextLine(); // Je ne saisis pas pourquoi, mais cette ligne est n�cessaire
			}

			System.out.println("\nVoulez-vous quitter (oui/non)?");
			choix = sc.nextLine();

		} while (!choix.equals("oui"));

		sc.close();

	}
}
