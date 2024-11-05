package fr.adaming.modele;

import java.util.Scanner;

public abstract class Personne {

	protected String nom;
	protected String prenom;
	protected int age;
	
	public Personne(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Votre nom : ");
		nom = sc.next();
		System.out.println("Votre prénom : ");
		prenom = sc.next();
		System.out.println("Age : ");
		age = sc.nextInt();
	}
	
	public Personne(String nom, String prenom, int age){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
}
