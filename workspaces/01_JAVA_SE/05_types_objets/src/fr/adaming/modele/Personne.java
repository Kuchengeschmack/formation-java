package fr.adaming.modele;

public class Personne {

	//1:-----D�claration des attributs de la classe
	private String nom;
	public String prenom;
	int age;
	
	
	//2:-----D�claration des constructeurs
	
	// constructeur vide (le constructeur par d�faut)
	public Personne() {
		
		System.out.println("--------- Je suis dans le constructeur vide !");
	}
	
	public Personne(String nom) {
		System.out.println("--------- Je suis dans le constructeur avec un seul param�tre !");
	}
	
	// constructeur avec des param�tres en entr�e
	public Personne(String nom, String pPrenom, int pAge) {
		
		this(nom);	// Appele le constructeur vide de la classe
		
		this.nom = nom;
		prenom = pPrenom;
		age = pAge;
	}
	
	//3:----- les getters et setters (l'accesseur et les modificateurs)
	// le getter sert � retourner la valeur de l'attribut
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String pNom) {
		nom = pNom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int pAge) {
		age = pAge;
	}
	
	//4:-----D�clarer les m�thodes m�tier de la classe
	// la signature d'une m�thode contient : visibilit� type_retour nom_methode(arguments)
	public void marcher() {
		// ce block, on l'appele le corps (l'impl�mentation de la m�thode
		
		System.out.println("Je marche chaque jour 10km pour garder la forme.");
	}
	
	public double dormir() {
		
		System.out.println("je dors pour me reposer");
		
		double duree =  5.5;
		
		return duree;
	}
	
	public void manger(String plat) {
		
		// les arguments d'une m�thode sont des variables locales
		System.out.println("Je suis en train de manger " + plat);
	}
	
	public void afficherInfos() {
		
		System.out.println("Nom : " + nom + ", Pr�nom : " + prenom + ", �ge : " + age);
	}
}
