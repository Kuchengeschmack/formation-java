package fr.adaming.presentation;

import java.util.*;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		// les types primitifs
		// ---- les entiers
		byte a = 15;

		short b = 155;

		int c = 1456789;

		int d = 17 / 4;
		System.out.println("la division entiere " + d);

		// le modulo : le reste de la division entière
		int h = 17 % 4;

		System.out.println("le reste de la division " + h);

		// l'incrémentation (décrémentation)
		int e = 17;
		e += 3;

		int i = 2;
		i += 1;
		i++;

		int m = 7;
		int y = 2 * m++;
		System.out.println("m = " + m);
		System.out.println("y = " + y);

		int n = 7;
		int z = 2 * ++n;

		System.out.println("\n n = " + n);
		System.out.println("z = " + z);

		System.out.println(i);
		System.out.println(i++);

		// Les réels
		double d1 = 78;
		System.out.println(d1);

		float f1 = 78.86f;

		// Les chars
		char ch1 = 'a';
		char ch2 = 97;
		char ch3 = '\u0061';

		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);

		// ==== Convertir des char en int
		int c2 = ch1;

		System.out.println(c2);

		// ==== Les booleans
		boolean val1 = false;

		// ==== les opérateurs logiques
		boolean v2 = 7 == 7;
		System.out.println(v2);

		boolean v3 = 7 != 7;
		System.out.println(v3);

		boolean v4 = !v3;
		System.out.println(v4);

		// ==== les autres opérateurs
		int age = 15;
		double moyenne = 1.0;

		boolean v5 = (age >= 18) && (moyenne > 10);
		System.out.println("la valeur de v5 est " + v5);

		boolean v6 = (age >= 18) || (moyenne > 10);
		System.out.println("la valeur de v6 est " + v6);

		// ==== Les chaînes de caractères
		String s = "TOTO à Paris";

		String s1 = new String("TOTO à Bordeaux");

		// récupérer la taille d'une chaîne de caractères
		int taille = s.length();
		System.out.println("la taille de s est: " + taille);

		// récupérer le char à un index donné
		char car = s.charAt(5);
		System.out.println(car);

		// les wrappers

	}

}
