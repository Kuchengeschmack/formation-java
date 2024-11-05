package fr.adaming.beans;

public class Employe {

	// Déclaration des attributs
	private String nom;
	private String prenom;
	private int age;
	
	// Déclaration des constructeurs
	public Employe() {
		super();
		System.out.println("--------------- Je suis dans le constructeur vide de Employe");
	}

	public Employe(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		
		System.out.println("--------------- Je suis dans le constructeur avec paramètres de Employe");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		
		System.out.println("----------- Je suis dans le setter du nom");
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		
		System.out.println("----------- Je suis dans le setter du prénom");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		
		System.out.println("----------- Je suis dans le setter de age");
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	

	
}
