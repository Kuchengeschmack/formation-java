package fr.adaming.modele;

public class Compte {

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
	
	public void retirerArgent(double somme) {
		if(somme <= solde) {
			this.solde -= somme;
		} else {
			System.out.println("Erreur, solde insuffisant.");
		}
	}
	
	public double consulterEtatCompte() {
		return solde;
	}
	
}
