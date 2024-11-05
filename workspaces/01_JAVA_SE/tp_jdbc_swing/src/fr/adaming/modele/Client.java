package fr.adaming.modele;

public class Client {

	// Déclaration des attributs
	private int numClient;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private int numTelephone;
	
	// Déclaration des constructeurs
	public Client() {
		super();
	}
	
	public Client(String nom, String prenom, String adresse, int codePostal, String ville, int numTelephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.numTelephone = numTelephone;
	}
	
	public Client(int numClient, String nom, String prenom, String adresse, int codePostal, String ville, int numTelephone) {
		super();
		this.numClient = numClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.numTelephone = numTelephone;
	}

	// Déclaration des accesseurs et des modificateurs
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}
	
	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	@Override
	public String toString() {
		return "Client N° " + numClient + ", NOM : " + nom.toUpperCase() + ", prénom : " + prenom + ", adresse : " + adresse
				+ ", " + codePostal + " " + ville + ", tél : (0)" + numTelephone;
	}
	
}
