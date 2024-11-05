package fr.adaming.modele;

public abstract class CompteEpargne extends Compte {

	public static double taux;
	
	public CompteEpargne() {
		// Il s'agit du constructeur par d�faut
		// Le constructeur de la classe m�re est appel� par d�faut
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
		return numero + "\t�pargne\t" + nomTitulaire + "\t" + solde + "�";
	}
}
