package fr.adaming.modele;

public class CompteCourant extends Compte {

	public static double decouvertAutorise; // La banque donne un découvert identique pour tous les comptes courants

	public CompteCourant() {
		// Il s'agit du constructeur par défaut
		// Le constructeur de la classe mère est appelé par défaut
	}
	
	public CompteCourant(int numero, String nomTitulaire, double solde) {
		super(numero, nomTitulaire, solde);
	}
	
	// On fait une redéfinition de la méthode retirerArgent
	// On n'oublie pas le mot-clef @Override
	@Override
	public void retirerArgent(double somme) {
		if(somme <= solde + decouvertAutorise) {
			this.solde -= somme;
		} else {
			System.out.println("Le retrait n'est pas possible car il dépasse le découvert autorisé.");
		}
		if (somme > solde && somme <= solde + decouvertAutorise) {
			System.out.println("Vous êtes maintenant à découvert.");
		}
	}

	@Override
	public String toString() {
		return numero + "\tcourant\t" + nomTitulaire + "\t" + solde + "€";
	}

	
}
