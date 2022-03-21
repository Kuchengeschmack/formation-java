package fr.adaming.modele;

public abstract class CompteEpargne extends Compte {

	public static double taux;
	
	public CompteEpargne() {
		// Il s'agit du constructeur par défaut
		// Le constructeur de la classe mère est appelé par défaut
	}
	
	public CompteEpargne(int numero, String nomTitulaire, double solde) {
		super(numero, nomTitulaire, solde);
	}
	
	public double calculInteretsAcquis() {
		this.solde = this.solde * (1 + this.taux);
		return this.solde * taux;
	}

	@Override
	public String toString() {
		return numero + "\tépargne\t" + nomTitulaire + "\t" + solde + "€";
	}
}
