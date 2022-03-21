package fr.adaming.modele;

public class Personne {

	String nom;
	String adresse;
	int numTelephone;
	
	public Personne() {
		
	}
	
	public Personne(String nom, String adresse, int numTelephone) {
		this.nom = nom;
		this.adresse = adresse;
		this.numTelephone = numTelephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", adresse=" + adresse + ", numTelephone=" + numTelephone + "]";
	}
}
