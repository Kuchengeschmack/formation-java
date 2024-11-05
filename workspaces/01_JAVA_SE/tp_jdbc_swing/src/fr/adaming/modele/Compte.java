package fr.adaming.modele;

public abstract class Compte {

	// D�claration des attributs
	protected int numCompte;
	protected double solde;
	protected int numClient;

	// D�claration des constructeurs

	// Constructeur vide
	public Compte() {
		super();
	}

	// Constructeur surcharg�
	public Compte(double solde) {
		super();
		this.solde = solde;
	}

	public Compte(int numCompte, double solde) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
	}

	public Compte(double solde, int numClient) {
		super();
		this.solde = solde;
		this.numClient = numClient;
	}

	public Compte(int numCompte, double solde, int numClient) {
		super();
		this.numClient = numClient;
		this.numCompte = numCompte;
		this.solde = solde;
	}

	// D�claration des accesseurs et des modificateurs
	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

}
