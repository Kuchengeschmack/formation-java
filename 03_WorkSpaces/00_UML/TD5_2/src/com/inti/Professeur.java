package com.inti;

public class Professeur extends Individu {

	private int anciennete;
	private double salaire;

	public Professeur()
	{
		
	}
	
	public Professeur(int identifiant, String nom, String prenom, int numSecu, int anciennete)
	{
		super(identifiant, nom, prenom, numSecu);
		this.anciennete = anciennete;
		this.setSalaire();
	}
	
	public void afficherInfos()
	{
		System.out.println("Professeur id : " + this.getIdentifiant() + ", nom : " + this.getNom() + ", prenom : " + this.getPrenom() + ", num Secu : " + this.getNumSecu() + ", annee d\'anciennete : " + this.getanciennete() + ", salaire : " + this.getSalaire());
	}
	
	public void setSalaire()
	{
		salaire = anciennete*50 + 1600;
	}

	public int getanciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
		this.setSalaire();
	}

	public double getSalaire() {
		return salaire;
	}
}
