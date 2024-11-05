package fr.adaming.modele;

public class Personne {

	// 1 ----- Attributs
	protected String nom;
	protected String prenom;
	protected int age;
	
	// 2 ----- Constructeurs
	public Personne() {
		System.out.println("--- Je suis le constructeur vide de Personne.");
	}
	
	public Personne(String nom, String prenom, int age) {
		
		this.nom = nom;
		this.prenom = nom;
		this.age = age;
		System.out.println("--- Je suis le constructeur surchagé de Personne.");
		
	}
	
	// 3 ----- Getters et Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// 4 ----- Méthodes
	public void marcher() {
		System.out.println("Je suis une personne et je marche.");
	}
	
	public void manger() {
		System.out.println("Je suis une personne et je mange.");
	}
}
