package com.inti;

import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {
		//System.out.println("Hello World");
		
//		Les variables
		
//		déclaration d'une variable : type nomVariable;
//		int age;
		// affectation de valeur à une variable : nomVariable = valeur;
//		age = -6;
//		
//		System.out.println("Age : " + age + " ans");
//		
//		// déclaration et affectation de variable
//		int age1 = 56;
//		
//		System.out.println("Age : " + age1 + " ans");
//		
//		// déclaration (et/ou affectation) de plusieurs variables
//		String nom = "Pierre", prenom = "Paul", metier = "bucheron", numSecu = "15834389";
//		
//		System.out.println("Nom : " + nom + ", prenom : " + prenom + ", metier : " + metier);
//		
//		double salaire = 1956.25;
//		double salaire1 =  3470.2;
//
//		System.out.println("Salaire : " + salaire + ", salaire1 : " + salaire1);
		
		// Conditions : if(conditions) { instructions; }
//		if(age >= 65)
//		{
//			System.out.println("Retraite");
//		}
//		else if(age >= 40)
//		{
//			System.out.println("Senior");
//		}
//		else if( age >= 18)
//		{
//			System.out.println("Actif");
//		}
//		else if (age >= 15)
//		{
//			System.out.println("Adolescent");
//		}
//		else if(age >= 12)
//		{
//			System.out.println("Enfant");
//		}
//		else if(age >= 2)
//		{
//			System.out.println("Enfant");
//		}
//		else if(age >= 0)
//		{
//			System.out.println("Bebe");
//		}
//		else
//		{
//			System.err.println("Age invalide");
//		}
//		
		// Les choix : switch(condition) : case 1 :instructions; case 2 : instructions; break;
		// default : instructions;
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Menu : ");
//		System.out.println("1 : retrait");
//		System.out.println("2 : depot");
//		System.out.println("1 : virement");
//		
//		System.out.println("Saisir votre choix :");
//		int choix = sc.nextInt();
//		
//		switch (choix) {
//		case 1:
//			System.out.println("Vous avez choisit le retrait.");
//			break;
//		case 2:
//			System.out.println("Vous avez choisit le depot.");
//			break;
//		case 3:
//			System.out.println("Vous avez choisit le virement.");
//			break;
//		default:
//			System.err.println("Mauvais choix. Saisir entre 1 et 3.");
//		}
		
		// Les boucles
		// for(initiation; conditions; incréments)
		// i++ -> i = i + 1
//		for(int i = 0; i < 10; i++)
//		{
//			System.out.println(i);
//		}
//		
//		int i = 0;
//		while(i<10)
//		{
//			System.out.println("nombre While : " + i++);
//		}
		
		int j = 0;
		do
		{
			System.out.println("nombre do while : " + j++);
		}while(j < 10);
		
	}

}
