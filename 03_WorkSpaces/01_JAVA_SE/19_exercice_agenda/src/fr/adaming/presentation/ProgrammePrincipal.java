package fr.adaming.presentation;

import java.util.Scanner;

import fr.adaming.modele.*;
import fr.adaming.service.GestionAgenda;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		boolean running = true;
		int choix;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bonjour");
		while (running) {
			
			
			System.out.println("Que voulez-vous faire ?\n 1 : Ajouter un contact     2 : Afficher le répertoire     3 : Rechercher un contact");
			System.out.println("0 : Quitter");
			choix = sc.nextInt();
			
			switch (choix) {
			case 0:
				System.out.println("A bientôt");
				running = false;
				break;
				
			case 1:
				System.out.println("Vous voulez ajouter un contact.");
				System.out.println("Veuillez saisir le nom du contact à ajouter : ");
				String nom = sc.next();
				System.out.println("Veuillez saisir l'adresse du contact à ajouter : ");
				String adresse = sc.next();
				System.out.println("Veuillez saisir le numéro de téléphone du contact à ajouter : ");
				int tel = sc.nextInt();
				Personne contact = new Personne(nom, adresse, tel);
				GestionAgenda.ajouterPersonne(contact);
				System.out.println("Votre contact a été ajouté dans votre répertoire.");
				System.out.println("Retour au menu principal.");
				break;
				
			case 2:
				System.out.println("Affichage du répertoire");
				GestionAgenda.affichageComplet();
				System.out.println("Retour au menu principal.");
				break;
				
			case 3:
				System.out.println("Veuillez saisir le prénom ou le nom du contact à rechercher : ");
				String recherche = sc.next();
				System.out.println(GestionAgenda.rechercherPersonne(recherche));
				System.out.println("Retour au menu principal.");
				break;
				
			default:
				System.out.println("Il faut choisir la bonne opération.");
				break;
			}
		}
		sc.close();
	}
}
