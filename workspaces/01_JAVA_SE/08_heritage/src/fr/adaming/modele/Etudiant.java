package fr.adaming.modele;

public class Etudiant extends Personne {

	private String cursus;
	
	public Etudiant() {
		System.out.println("--- Je suis dans le constructeur vide de Etudiant.");
	}
	
	public Etudiant(String nom, String prenom, int age, String cursus) {
		
		// Appel expliciter du constructeur avec params de la classe m�re
		super(nom, prenom, age);
		System.out.println("--- Je suis dans le constructeur surcharg� de Etudiant.");
		this.cursus = cursus;
	}

	// D�claration des getters et setters
	public String getCursus() {
		return cursus;
	}

	public void setCursus(String cursus) {
		this.cursus = cursus;
	}

	// D�claration des m�thodes m�tiers de l'�tudiant
	public void reviser() {
		System.out.println("Je r�vise mes cours !");
	}
	
	/* La surcharge des m�thodes : c'est le fait de pouvori d�finir dans la m�me
	 * classe plusieurs m�thodes avec la m�me visibilit�, le m�me type de retour, le m�me nom
	 * et la diff�rence sera sur les arguments en entr�e :
	 *  - le nombre
	 *  - le type
	 *  - leur ordre
	 */
	
	public void reviser(String cours) {
		System.out.println("Je suis en train de r�viser mes cours !");
	}
	
	public void reviser(double duree) {
		System.out.println("Je suis en train de r�viser mes cours !");
	}
	
	public void reviser(String cours, double duree) {
		System.out.println("Je suis en train de r�viser mes cours !");
	}
	
	public void reviser(double duree, String cours) {
		System.out.println("Je suis en train de r�viser mes cours !");
	}
	
	public String afficherInfos() {
		
		String infos = "Nom : " + this.nom; // Soit on rend l'attribut de la classe m�re protected, soit on utilise le getter public de la classe m�re
		return infos;
	}
	
	// Red�finition de la m�thode h�rit�e : la signature de la m�thode reste identique : visibilit� type_retour nom(arguments) exceptions
	@Override // Cette annotation est une m�tadonn�e, elle sert �  des informations sur notre code (red�finition)
	public void manger() {
		
		// appel de la m�thode manger de Personne
		super.manger();	// super fait r�f�rence � la classe m�re
		System.out.println("Je suis �tudiant, je mange au restau U.");
	}
	
}
