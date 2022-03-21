package com.inti;

import java.util.Scanner;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ex10(n);

	}

	public static void ex1(int n) {
		System.out.println("==== Exo1");

		for (int i = n; i > 0; i--) {
			System.out.println(i);
		}
	}

	public static void ex2(int n) {
		System.out.println("==== Exo2");

		// Exo2
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	public static void ex3(int n) {
		System.out.println("==== Exo3");

		// Exo3
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
	}

	public static void ex4(int n) {
		System.out.println("==== Exo4");

		// Exo4
		int somme = 0;
		for (int i = 1; i <= n; i++) {
			somme += i;
		}
		System.out.println("Somme des nb de 1 à " + n + " = " + somme);

	}

	public static void ex5(int n) {
		System.out.println("==== Exo5");

		// Exo5
		int somme = 0;
		for (int i = 2; i <= n; i += 2) {
			somme += i;
		}
		System.out.println("Somme des nb de 1 à " + n + " = " + somme);
	}

	public static void ex6(int n) {
		System.out.println("==== Exo6");
		for (int i = 0; i <= 12; i++) {
			System.out.println(n + " fois " + i + " = " + n * i);
		}
	}

	public static void ex7(int n) {
		System.out.println("==== Exo7");
		String str = Integer.toString(n);
		System.out.println("L'entier renseigné comporte " + str.length() + " chiffres.");
	}

	public static void ex8(int n) {
		System.out.println("==== Exo8");
		String str = Integer.toString(n);
		int somme = 0;

		for (int i = 0; i < str.length(); i++) {
			Character c = new Character(str.charAt(i));
			somme += Integer.parseInt(c.toString());
		}
		System.out.println("La somme des chiffres de l'entier renseigné est égale à " + somme);
	}

	public static void ex9(int n) {
		System.out.println("==== Exo9");
		String str = Integer.toString(n);
		boolean flag = true;
		char c1, c2;
		int nb = str.length() - 1;

		for (int i = 0; i < str.length() / 2; i++) {
			c1 = str.charAt(i);
			c2 = str.charAt(nb - i);
			if (c1 != c2) {
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Ce nombre est un palindrome.");
		} else {
			System.out.println("Ce nombre n\'est pas un palindrome.");
		}
	}

	public static void ex10(int n) {
		System.out.println("==== Exo10");
		String facteurs = new String();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				facteurs += i + " ";
			}
		}
		System.out.println("Les facteurs de " + n + " sont : " + facteurs);
	}

	public static void ex11(int n) {
		System.out.println("==== Exo11");
		int factorielle = n;
		for (int i = n - 1; i > 1; i--) {
			factorielle *= i;
		}
		System.out.println(n + "! = " + factorielle);
	}

	public static void ex12(int n) {
		System.out.println("==== Exo12");
		int somme = 1;

		for (int i = 1; i <= 7; i++) {
			somme += i * Math.pow(n, i);
		}
		System.out.println("Le polynôme évalué en " + n + " vaut " + somme);
	}

	public static void compteLettre() {
		Scanner sc = new Scanner(System.in);

		String phrase = sc.nextLine();

		int compteur = 0;

		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == 's') {
				compteur++;
			}
		}

		System.out.println("La phrase : " + phrase + "\ncontient " + compteur + " fois la lettre \'s\'.");
	}

}
