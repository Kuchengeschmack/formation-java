package fr.adaming.modele;

public class Personne {

	// Attributs
	private String prenom;
	private String nom;
	private Personne conjoint = null;	// Pour les célibataires, le conjoint est l'objet null, sinon pointe vers le conjoint
	private Acte a;
	
	// Constructeurs
	public Personne() {
		
	}
	
	public Personne(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}
	
	// Accesseurs et modificateurs
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Personne getConjoint() {
		return conjoint;
	}


	public void setConjoint(Personne conjoint) {
		this.conjoint = conjoint;
	}

	public Acte getA() {
		return a;
	}

	public void setA(Acte a) {
		this.a = a;
	}
	
	
}
