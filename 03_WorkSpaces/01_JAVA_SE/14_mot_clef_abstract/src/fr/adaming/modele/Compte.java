package fr.adaming.modele;

public abstract class Compte {

	protected int numero;
	protected String nomTitulaire;
	protected double solde;
	
	public Compte() {
		
	}
	
	public Compte(int numero, String nomTitulaire, double solde) {
		this.numero = numero;
		this.nomTitulaire = nomTitulaire;
		this.solde = solde;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void deposerArgent(double somme) {
		solde += somme;
	}
	
	public abstract void retirerArgent(double somme);

	
	public double consulterEtatCompte() {
		return solde;
	}
	
}
