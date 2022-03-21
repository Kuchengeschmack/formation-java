package com.inti;

public class Etudiant extends Individu {

	private int anneeEtude;
	private double fraisInscription;
	
	public Etudiant()
	{
		
	}
	
	public Etudiant(int identifiant, String nom, String prenom, int numSecu, int anneeEtude)
	{
		super(identifiant, nom, prenom, numSecu);
		this.anneeEtude = anneeEtude;
		this.setFraisInscription();
	}
	
	public void afficherInfos()
	{
		System.out.println("Etudiant id : " + this.getIdentifiant() + ", nom : " + this.getNom() + ", prenom : " + this.getPrenom() + ", num Secu : " + this.getNumSecu() + ", annee d\'etudes : " + this.getAnneeEtude() + ", frais d\'inscription : " + this.getFraisInscription());
	}
	
	public void setFraisInscription()
	{
		fraisInscription = anneeEtude*150;
	}

	public int getAnneeEtude() {
		return anneeEtude;
	}

	public void setAnneeEtude(int anneeEtude) {
		this.anneeEtude = anneeEtude;
		this.setFraisInscription();
	}

	public double getFraisInscription() {
		return fraisInscription;
	}
	
}
