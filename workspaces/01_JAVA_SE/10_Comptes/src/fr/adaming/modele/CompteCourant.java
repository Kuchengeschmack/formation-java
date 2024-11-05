package fr.adaming.modele;

public class CompteCourant extends Compte {

	public static double decouvertAutorise; // La banque donne un d�couvert identique pour tous les comptes courants

	public CompteCourant() {
		// Il s'agit du constructeur par d�faut
		// Le constructeur de la classe m�re est appel� par d�faut
	}
	
	public CompteCourant(int numero, String nomTitulaire, double solde) {
		super(numero, nomTitulaire, solde);
	}
	
	// On fait une red�finition de la m�thode retirerArgent
	// On n'oublie pas le mot-clef @Override
	@Override
	public void retirerArgent(double somme) {
		if(somme <= solde + decouvertAutorise) {
			this.solde -= somme;
		} else {
			System.out.println("Le retrait n'est pas possible car il d�passe le d�couvert autoris�.");
		}
		if (somme > solde && somme <= solde + decouvertAutorise) {
			System.out.println("Vous �tes maintenant � d�couvert.");
		}
	}

	@Override
	public String toString() {
		return numero + "\tcourant\t" + nomTitulaire + "\t" + solde + "�";
	}

	
}
