package fr.adaming.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.UnsupportedLookAndFeelException;

import fr.adaming.vue.console.VueConsole;
import fr.adaming.vue.swing.VueSwing;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choixVue = 0;

		// Implémenter le choix de la vue avec un switch

		/*
		 * Client OK Compte courant --> Attention à la fonction virement, vérifier que
		 * les deux comptes soient ok avant d'effectuer le retrait ou le dépôt
		 * Implémenter un unique compte par client.
		 */

		try {
			System.out.println("Quelle vue voulez-vous lancer ?\n\t1- Vue console\n\t2- Vue Swing");
			choixVue = sc.nextInt();
			sc.nextLine();

			switch (choixVue) {
			case 1:
				VueConsole.lancerConsole();
				break;

			case 2:
				try {
					VueSwing.lancerSwing();
				} catch (UnsupportedLookAndFeelException e) {
					System.out.println("\n---- La vue Swing n'a pas pu être lancée.\n");
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Il faut choisir une option valide.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Il faut choisir une option valide.");
		}

		sc.close();
	}

}
