package fr.adaming.modele;

public class Etudiant {

	// Déclaration des attributs (les variabls d'instance)
	private String nom;
	private String prenom;
	
	// un attribut avec static est une variable de classe
	// si je la modifie dans un objet, elle sera modifiée par tous les autres objets
	private static int compteur = 0;	// Cette valeur est partagée par tous les objets de la classe
	
	public Etudiant() {
		
		Etudiant.compteur++;
	}
	
	public Etudiant(String nom, String prenom) {
		
		this.nom = nom;
		this.prenom = prenom;
		Etudiant.compteur++;
	}
	
	public int getCompteur() {
		
		return Etudiant.compteur;
	}

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

	public void setCompteur(int compteur) {
		Etudiant.compteur = compteur;
	}
	
	// Déclaration des méthodes de la classe
	public void manger() {
		System.out.println("Je mange au Fouquet's.");
	}
	
	public static void reviser() {
		System.out.println("Je suis en train de réviser ... tu hors de ma vue !");
	}
	
	
}
