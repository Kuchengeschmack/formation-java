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

		// Déclaration des variables et objets utilisés par l'interface des choix et des
		// objets services
		Scanner sc = new Scanner(System.in);

		String choix = "non";
		int catOp;
		int op;
		int verif; // Pour vérifier les retours de méthodes
		boolean verifBool; // Pour vérifier les virements

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
		Double solde; // En SQL, les tables compte_courant et compte_epargne possèdent un champ
		int numClient; // 'num_client'
		Double montant;
		List<Compte> listeCompte;

		do {
			try {
				System.out.println("Choisir une catégorie d'opération : ");
				System.out.println("\t1- Client");
				System.out.println("\t2- Compte courant");
				System.out.println("\t3- Compte épargne");

				catOp = sc.nextInt();
				sc.nextLine(); // Retour chariot après l'acquisition de l'int
				switch (catOp) {

				// Opération sur un client
				case 1:
					System.out.println("Choisir une opération : ");
					System.out.println("\t1- Ajouter un client");
					System.out.println("\t2- Supprimer un client");
					System.out.println("\t3- Modifier un client");
					System.out.println("\t4- Afficher tous les clients");
					System.out.println("\t5- Chercher un client par son numéro de client");

					op = sc.nextInt();
					sc.nextLine(); // Retour chariot après l'acquisition de l'int

					switch (op) {
					case 1:
						System.out.println("Saisir le nom : ");
						nom = sc.nextLine();
						System.out.println("Saisir le prénom : ");
						prenom = sc.nextLine();
						System.out.println("Saisir l'adresse : ");
						adresse = sc.nextLine();
						System.out.println("Saisir le code postal : ");
						codePostal = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir la ville : ");
						ville = sc.nextLine();
						System.out.println("Saisir le numéro de téléphone : ");
						numTelephone = sc.nextInt();
						sc.nextLine();

						client = new Client(nom, prenom, adresse, codePostal, ville, numTelephone);

						verif = clientService.ajouterClientService(client);
						if (verif != 0) {
							System.out.println("\n---- Le client a bien été ajouté.\n");
						} else {
							System.out.println("\n---- Echec de l'ajout du client.\n");
						}

						break;
					case 2:
						System.out.println("Saisir le numéro du client à supprimer : ");
						numClient = sc.nextInt();
						sc.nextLine();
						verif = clientService.supprimerClientService(numClient);
						if (verif != 0) {
							System.out.println("\n---- Le client a bien été supprimé.\n");
						} else {
							System.out.println("\n---- Echec de la suppression du client.\n");
						}

						break;
					case 3:
						System.out.println("Saisir le numéro du client à modifier : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le nom : ");
						nom = sc.nextLine();
						System.out.println("Saisir le prénom : ");
						prenom = sc.nextLine();
						System.out.println("Saisir l'adresse : ");
						adresse = sc.nextLine();
						System.out.println("Saisir le code postal : ");
						codePostal = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir la ville : ");
						ville = sc.nextLine();
						System.out.println("Saisir le numéro de téléphone : ");
						numTelephone = sc.nextInt();
						sc.nextLine();

						client = new Client(numClient, nom, prenom, adresse, codePostal, ville, numTelephone);

						verif = clientService.modifierClientService(client);
						if (verif != 0) {
							System.out.println("\n---- Le client a bien été modifié.\n");
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
							System.out.println("\n---- La base de données client est vide.\n");
						}

						break;
					case 5:
						System.out.println("Saisir le numéro du client à rechercher : ");
						numClient = sc.nextInt();
						sc.nextLine();
						client = clientService.chercherClientService(numClient);
						if (client != null) {
							System.out.println(client);
						} else {
							System.out.println("\n---- Le client recherché n'existe pas dans la base de données.\n");
						}

						break;
					default:
						System.out.println("\n---- Il faut choisir la bonne opération.\n");

					}

					break;

				// Opération sur un compte courant
				case 2:
					System.out.println("Choisir une opération : ");
					System.out.println("\t1- Ajouter un compte courant");
					System.out.println("\t2- Supprimer un compte courant");
					System.out.println("\t3- Modifier un compte courant");
					System.out.println("\t4- Afficher tous les comptes courants");
					System.out.println("\t5- Chercher un compte courant par son numéro de compte");
					System.out.println("\t6- Chercher un compte courant par son numéro de client");
					System.out.println("\t7- Retirer de l'argent d'un compte courant");
					System.out.println("\t8- Déposer de l'argent sur un compte courant");
					System.out.println("\t9- Réaliser un virement d'un compte courant à un autre compte courant");

					op = sc.nextInt();
					sc.nextLine(); // Retour chariot après l'acquisition de l'int

					switch (op) {
					case 1:
						System.out.println("Saisir le numéro de compte : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le numéro de client du propriétaire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						cc = new CompteCourant(numCompte, solde, numClient);
						verif = courantService.attribuerCompteService(cc);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien été créé et attribué.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu être créé.\n");
						}

						break;
					case 2:
						System.out.println("Saisir le numéro de compte à supprimer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						verif = courantService.supprimerCompteService(numCompte);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien été supprimé.\n");
						} else {
							System.out.println("\n----- Le compte n'a pas pu être supprimé.\n");
						}

						break;
					case 3:
						System.out.println("Saisir le numéro de compte à modifier : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le numéro de client du propriétaire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						cc = new CompteCourant(numCompte, solde, numClient);
						verif = courantService.modifierCompteService(cc);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien été modifié.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu être modifié.\n");
						}

						break;
					case 4:
						listeCompte = courantService.getAllCompteService();

						if (listeCompte.size() > 0) {
							for (Compte c : listeCompte) {
								System.out.println(c);
							}
						} else {
							System.out.println("\n---- Il n'existe aucun compte dans la base de données.\n");
						}

						break;
					case 5:
						System.out.println("Saisir le numéro de compte à rechercher : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						Compte c = courantService.chercherIdCompteService(numCompte);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherché n'existe pas dans la base de données.\n");
						}

						break;
					case 6:
						System.out.println("Saisir le numéro de client du compte à rechercher : ");
						numClient = sc.nextInt();
						sc.nextLine();
						c = courantService.chercherIdClientCompteService(numClient);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherché n'existe pas dans la base de données.\n");
						}

						break;
					case 7:
						System.out.println("Saisir le numéro de compte duquel retirer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant à retirer : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = courantService.retirerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le retrait a bien été effectué.\n");
						} else {
							System.out.println("\n---- Le retrait n'a pas pu être effectué.\n");
						}

						break;
					case 8:
						System.out.println("Saisir le numéro de compte sur lequel déposer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant à déposer : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = courantService.deposerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le dépôt a bien été effectué.\n");
						} else {
							System.out.println("\n---- Le dépôt n'a pas pu être effectué.\n");
						}

						break;
					case 9:
						System.out.println("Saisir le numéro de compte à débiter : ");
						numDebit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le numéro de compte à créditer : ");
						numCredit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisissez le montant à virer : ");
						montant = sc.nextDouble();
						sc.nextLine();
						verifBool = courantService.virerCompteService(numDebit, numCredit, montant);
						if (verifBool) {
							System.out.println("\n---- Le virement a bien été effectué.\n");
						} else {
							System.out.println("\n---- Le virement n'a pas pu être effectué.\n");
						}

						break;
					default:
						System.out.println("\n---- Il faut choisir la bonne opération.\n");
					}

					break;

				// Opération sur un compte épargne
				case 3:
					System.out.println("Choisir une opération : ");
					System.out.println("\t1- Ajouter un compte épargne");
					System.out.println("\t2- Supprimer un compte épargne");
					System.out.println("\t3- Modifier un compte épargne");
					System.out.println("\t4- Afficher tous les comptes épargne");
					System.out.println("\t5- Chercher un compte épargne par son numéro de compte");
					System.out.println("\t6- Chercher un compte épargne par son numéro de client");
					System.out.println("\t7- Retirer de l'argent d'un compte épargne");
					System.out.println("\t8- Déposer de l'argent sur un compte épargne");
					System.out.println("\t9- Réaliser un virement d'un compte épargne à un autre compte épargne");

					op = sc.nextInt();
					sc.nextLine(); // Retour chariot après l'acquisition de l'int

					switch (op) {
					case 1:
						System.out.println("Saisir le numéro de compte : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le numéro de client du propriétaire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						ce = new CompteEpargne(numCompte, solde, numClient);
						verif = epargneService.attribuerCompteService(ce);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien été créé et attribué.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu être créé.\n");
						}

						break;
					case 2:
						System.out.println("Saisir le numéro de compte à supprimer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						verif = epargneService.supprimerCompteService(numCompte);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien été supprimé.\n");
						} else {
							System.out.println("\n----- Le compte n'a pas pu être supprimé.\n");
						}

						break;
					case 3:
						System.out.println("Saisir le numéro de compte à modifier : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le numéro de client du propriétaire : ");
						numClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le solde du compte : ");
						solde = sc.nextDouble();
						sc.nextLine();

						ce = new CompteEpargne(numCompte, solde, numClient);
						verif = epargneService.modifierCompteService(ce);
						if (verif != 0) {
							System.out.println("\n---- Le compte a bien été modifié.\n");
						} else {
							System.out.println("\n---- Le compte n'a pas pu être modifié.\n");
						}
						break;
					case 4:
						listeCompte = epargneService.getAllCompteService();
						if (listeCompte.size() > 0) {
							for (Compte c : listeCompte) {
								System.out.println(c);
							}
						} else {
							System.out.println("\n---- Il n'existe aucun compte dans la base de données.\n");
						}

						break;
					case 5:
						System.out.println("Saisir le numéro de compte à rechercher : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						Compte c = epargneService.chercherIdCompteService(numCompte);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherché n'existe pas dans la base de données.\n");
						}
						break;
					case 6:
						System.out.println("Saisir le numéro de client du compte à rechercher : ");
						numClient = sc.nextInt();
						sc.nextLine();
						c = epargneService.chercherIdClientCompteService(numClient);
						if (c != null) {
							System.out.println(c);
						} else {
							System.out.println("\n---- Le compte recherché n'existe pas dans la base de données.\n");
						}
						break;
					case 7:
						System.out.println("Saisir le numéro de compte duquel retirer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant à retirer : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = epargneService.retirerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le retrait a bien été effectué.\n");
						} else {
							System.out.println("\n---- Le retrait n'a pas pu être effectué.\n");
						}

						break;
					case 8:
						System.out.println("Saisir le numéro de compte sur lequel déposer : ");
						numCompte = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le montant à déposer : ");
						montant = sc.nextDouble();
						sc.nextLine();

						verif = epargneService.deposerCompteService(numCompte, montant);
						if (verif != 0) {
							System.out.println("\n---- Le dépôt a bien été effectué.\n");
						} else {
							System.out.println("\n---- Le dépôt n'a pas pu être effectué.\n");
						}
						break;
					case 9:
						System.out.println("Saisir le numéro de compte à débiter : ");
						numDebit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisir le numéro de compte à créditer : ");
						numCredit = sc.nextInt();
						sc.nextLine();
						System.out.println("Saisissez le montant à virer : ");
						montant = sc.nextDouble();
						sc.nextLine();
						verifBool = epargneService.virerCompteService(numDebit, numCredit, montant);
						if (verifBool) {
							System.out.println("\n---- Le virement a bien été effectué.\n");
						} else {
							System.out.println("\n---- Le virement n'a pas pu être effectué.\n");
						}
						break;

					default:
						System.out.println("\n---- Il faut choisir la bonne opération.\n");
					}

					break;

				default:
					System.out.println("\n---- Il faut choisir la bonne opération.\n");

				}
			} catch (InputMismatchException e) {
				System.out.println("\n---- Il faut choisir la bonne opération.\n");
				sc.nextLine(); // Je ne saisis pas pourquoi, mais cette ligne est nécessaire
			}

			System.out.println("\nVoulez-vous quitter (oui/non)?");
			choix = sc.nextLine();

		} while (!choix.equals("oui"));

		sc.close();

	}
}
