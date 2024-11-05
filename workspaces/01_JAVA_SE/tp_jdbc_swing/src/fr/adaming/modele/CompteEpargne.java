package fr.adaming.modele;

public class CompteEpargne extends Compte {

	public final static double TAUX_D_INTERET = 0.03;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(double solde) {
		super(solde);
	}
	
	public CompteEpargne(int numCompte, double solde) {
		super(numCompte, solde);
	}
	
	public CompteEpargne(double solde, int numClient) {
		super(solde, numClient);
	}
	
	public CompteEpargne(int numCompte, double solde, int numClient) {
		super(numCompte, solde, numClient);
	}

	@Override
	public String toString() {
		return "Compte Epargne N° : " + numCompte + ", solde : " + solde + " €, N° client : " + numClient;
	}
}
