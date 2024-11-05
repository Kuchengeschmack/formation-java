package fr.adaming.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Employe {

	// Déclaration des attributs
	@Value(value = "TOTO")
	private String nom;

	@Value(value = "Titi")
	private String prenom;

	@Value(value = "23")
	private int age;

	@Autowired // Cette notation permet d'injecter des collaborateurs (les types objets)
	Adresse adresse;

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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse=" + adresse + "]";
	}


}
