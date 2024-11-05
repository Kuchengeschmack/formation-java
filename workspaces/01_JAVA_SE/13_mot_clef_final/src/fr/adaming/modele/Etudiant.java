package fr.adaming.modele;

public class Etudiant extends Personne {

	private String cursus;
	
	public Etudiant() {
		System.out.println("--- Je suis dans le constructeur vide de Etudiant.");
	}
	
	public Etudiant(String nom, String prenom, int age, String cursus) {
		
		// Appel expliciter du constructeur avec params de la classe mère
		super(nom, prenom, age);
		System.out.println("--- Je suis dans le constructeur surchargé de Etudiant.");
		this.cursus = cursus;
	}

	// Déclaration des getters et setters
	public String getCursus() {
		return cursus;
	}

	public void setCursus(String cursus) {
		this.cursus = cursus;
	}

	// Déclaration des méthodes métiers de l'étudiant
	public void reviser() {
		System.out.println("Je révise mes cours !");
	}
	
	/* La surcharge des méthodes : c'est le fait de pouvori définir dans la même
	 * classe plusieurs méthodes avec la même visibilité, le même type de retour, le même nom
	 * et la différence sera sur les arguments en entrée :
	 *  - le nombre
	 *  - le type
	 *  - leur ordre
	 */
	
	public void reviser(String cours) {
		System.out.println("Je suis en train de réviser mes cours !");
	}
	
	public void reviser(double duree) {
		System.out.println("Je suis en train de réviser mes cours !");
	}
	
	public void reviser(String cours, double duree) {
		System.out.println("Je suis en train de réviser mes cours !");
	}
	
	public void reviser(double duree, String cours) {
		System.out.println("Je suis en train de réviser mes cours !");
	}
	
	public String afficherInfos() {
		
		String infos = "Nom : " + this.nom; // Soit on rend l'attribut de la classe mère protected, soit on utilise le getter public de la classe mère
		return infos;
	}
	
	// Redéfinition de la méthode héritée : la signature de la méthode reste identique : visibilité type_retour nom(arguments) exceptions
	@Override // Cette annotation est une métadonnée, elle sert à  des informations sur notre code (redéfinition)
	public void manger() {
		
		// appel de la méthode manger de Personne
		super.manger();	// super fait référence à la classe mère
		System.out.println("Je suis étudiant, je mange au restau U.");
	}
	
}
