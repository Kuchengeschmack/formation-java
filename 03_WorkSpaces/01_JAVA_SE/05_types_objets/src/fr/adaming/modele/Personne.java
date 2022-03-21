package fr.adaming.modele;

public class Personne {

	//1:-----Déclaration des attributs de la classe
	private String nom;
	public String prenom;
	int age;
	
	
	//2:-----Déclaration des constructeurs
	
	// constructeur vide (le constructeur par défaut)
	public Personne() {
		
		System.out.println("--------- Je suis dans le constructeur vide !");
	}
	
	public Personne(String nom) {
		System.out.println("--------- Je suis dans le constructeur avec un seul paramètre !");
	}
	
	// constructeur avec des paramètres en entrée
	public Personne(String nom, String pPrenom, int pAge) {
		
		this(nom);	// Appele le constructeur vide de la classe
		
		this.nom = nom;
		prenom = pPrenom;
		age = pAge;
	}
	
	//3:----- les getters et setters (l'accesseur et les modificateurs)
	// le getter sert à retourner la valeur de l'attribut
	
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
	
	//4:-----Déclarer les méthodes métier de la classe
	// la signature d'une méthode contient : visibilité type_retour nom_methode(arguments)
	public void marcher() {
		// ce block, on l'appele le corps (l'implémentation de la méthode
		
		System.out.println("Je marche chaque jour 10km pour garder la forme.");
	}
	
	public double dormir() {
		
		System.out.println("je dors pour me reposer");
		
		double duree =  5.5;
		
		return duree;
	}
	
	public void manger(String plat) {
		
		// les arguments d'une méthode sont des variables locales
		System.out.println("Je suis en train de manger " + plat);
	}
	
	public void afficherInfos() {
		
		System.out.println("Nom : " + nom + ", Prénom : " + prenom + ", Âge : " + age);
	}
}
