package fr.adaming.beans;

public class Entreprise {

	private String nom;

	private Employe employe;

	private Employe directeur;

	public Entreprise() {
		super();

		System.out.println("------------ Je suis dans le constructeur vide de Entreprise");
	}

	public Entreprise(String nom, Employe employe, Employe directeur) {
		super();
		this.nom = nom;
		this.employe = employe;
		this.directeur = directeur;

		System.out.println("------------ Je suis dans le constructeur avec params de Entreprise");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;

		System.out.println("------------ Je suis dans le setter de nom de l'entreprise");
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;

		System.out.println("------------ Je suis dans le setter de l'employe de l'entreprise");
	}

	public Employe getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Employe directeur) {
		this.directeur = directeur;

		System.out.println("------------ Je suis dans le setter du directeur de l'entreprise");
	}

	@Override
	public String toString() {
		return "Entreprise [nom=" + nom + ", employe=" + employe + ", directeur=" + directeur + "]";
	}

}
