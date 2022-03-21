package com.inti;

public class Individu {

	private int identifiant;
	private String nom;
	private String prenom;
	private int numSecu;
	
	public Individu()
	{
		
	}
	
	public Individu(int identifiant, String nom, String prenom, int numSecu)
	{
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu = numSecu;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
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

	public int getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(int numSecu) {
		this.numSecu = numSecu;
	}
}
