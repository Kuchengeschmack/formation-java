package com.inti;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// Les fonctions : type nomFonction(type1 arg1, type2 arg2){ instructions;}
	public static int sommeEntier(int a, int b)
	{
		int somme = a + b;
		return somme;
	}

	public static void main(String[] args) {
		
		// Ex1
//		int n;
//		n = 10;
//		int S;
//		S = 0;
//		
//		for(int i = 1; i <= n; i++)
//		{
//			for(int j=1; j <= i ; j++)
//			{
//				S += i + j;
//			}			
//		}
//		
//		System.out.println(S);
		
		//Ex2
//		Scanner sc1 = new Scanner(System.in);
//		Scanner sc2 = new Scanner(System.in);
//		double a = sc1.nextDouble();
//		double b = sc2.nextDouble();
//		
//		double produit = a * b;
//		
//		DecimalFormat df = new DecimalFormat("0.###");
//		
//		System.out.println("Resultat : " + df.format(produit));
//		System.out.printlf("Resultat : %.3f", r);
		
		// Ex3
//		int a = 1;
//		int b = 2;
//		int c;
//		
//		System.out.println("Avant permutation :");
//		System.out.println("a = " + a);
//		System.out.println("b = " + b);
//		
//		c = a;
//		a = b;
//		b = c;
//		
//		System.out.println("Après permutation :");
//		System.out.println("a = " + a);
//		System.out.println("b = " + b);
		
		// Ex4
//		int a;
//		int b;
//		int c;
//		
//		Scanner sc1 = new Scanner(System.in);
//		Scanner sc2 = new Scanner(System.in);
//		Scanner sc3 = new Scanner(System.in);
//		a = sc1.nextInt();
//		b = sc2.nextInt();
//		c = sc3.nextInt();
//		
//		double moy = (double) (a + b + c)/3;
//		
//		
//		DecimalFormat df = new DecimalFormat("0.##");
//		
//		System.out.println("Resultat : " + df.format(moy));
		
		// Ex5
//		char lettre;
//		Scanner sc = new Scanner(System.in);
//		lettre = sc.next().charAt(0); // Conversion implicite de String à char
//		System.out.printf("%c", lettre + 1);
		
		// Ex6
//		double r_1;
//		double r_2;
//		double aire;
//		
//		Scanner sc1 = new Scanner(System.in);
//		Scanner sc2 = new Scanner(System.in);
//		
//		r_1 = sc1.nextDouble();
//		r_2 = sc2.nextDouble();
//		aire = Math.PI*Math.pow(r_1, 2) - Math.PI*Math.pow(r_2, 2);
//		
//		if(aire < 0)
//		{
//			aire = -aire;
//		}
//		
//		System.out.println("Aire : " + aire);
		
		// Ex7
//		int a;
//		int b;
//		
//		Scanner sc1 = new Scanner(System.in);
//		Scanner sc2 = new Scanner(System.in);
//
//		a = sc1.nextInt();
//		b = sc2.nextInt();
//		
//		if(a > b)
//		{
//			System.out.println(a);
//		}
//		else
//		{
//			System.out.println(b);
//		}
		
		// Ex8
//		String fraction;
//		Scanner sc = new Scanner(System.in);
//		fraction = sc.toString();
//		
//		System.out.println(fraction);
		
		// Les tableaux statiques
		// type nomTableau[]
		
//		Scanner sc = new Scanner(System.in);
//		
//		int tabAge[] = new int[3];
//		tabAge[0] = 38;
//		tabAge[1] = 65;
//		
//		System.out.println("Tab case 1 : " + tabAge[2]);
//		
//		for(int i=0; i<tabAge.length; i++)
//		{
//			System.out.println("Saisir l'age de l'individu " + i + " : ");
//			tabAge[i] = sc.nextInt();
//		}
//		
//		// boucle affichage
//		for(int i = 0; i<tabAge.length; i++)
//		{
//			System.out.println("Age individu " + i + " : " + tabAge[i]);
//		}
		
//		// tab avec des valeurs par défaut:
//		String tabNom[] = {"Paul", "Sophie", "Pierre"};
//		for(int i = 0; i<tabNom.length; i++)
//		{
//			System.out.println("Nom personne " + i + " : " + tabNom[i]);
//		}
		
		// Les collections (tableau dynamique, liste)
//		ArrayList<Double> listeSalaire = new ArrayList<Double>();
//		
//		listeSalaire.add(1986.65);
//		listeSalaire.add(2587.25);
//		System.out.println("salaire : " + listeSalaire.get(1));
//		
//		int choix = 1, numIndividu = 1; // 1 : continuer, 2 : arrêter la boucle
//		
//		Scanner sc = new Scanner(System.in);
//		
//		do
//		{
//			System.out.println("Saisir le salaire de l'individu " + numIndividu);
//			listeSalaire.add(sc.nextDouble());
//			System.out.println("Saisir 1 pour ajouter un nouveau salaire et autre pour arreter : ");
//			choix = sc.nextInt();
//			numIndividu++;
//		}while(choix == 1);
//		
//		
//		// boucle for pour les listes
//		for(Double sal : listeSalaire)
//		{
//			System.out.println("Salaire : " + sal);
//		}
//		
//		// equivalent avec boucle for classique
//		for(int i = 0; i < listeSalaire.size(); i++)
//		{
//			System.out.println("Salaire : " + listeSalaire.get(i));
//		}
		
		System.out.println(sommeEntier(1,1));
		
		
	}

}
