package fr.adaming.modele;

public class CompteCourant extends Compte {

	public final static double DECOUVERT_AUTORISE = -100;

	public CompteCourant() {
		super();
	}

	public CompteCourant(double solde) {
		super(solde);
	}
	
	public CompteCourant(int numCompte, double solde) {
		super(numCompte, solde);
	}
	
	public CompteCourant(double solde, int numClient) {
		super(solde, numClient);
	}
	
	public CompteCourant(int numCompte, double solde, int numClient) {
		super(numCompte, solde, numClient);
	}

	@Override
	public String toString() {
		return "Compte Courant N° : " + numCompte + ", solde : " + solde + " €, N° client : " + numClient;
	}

}
