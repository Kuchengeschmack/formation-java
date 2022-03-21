package fr.adaming.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ing")
public class Ingenieur extends Personne {

	// Déclaration des attributs
	private String diplome;

	public Ingenieur() {
		super();
	}

	public Ingenieur(String nom, String prenom, String diplome) {
		super(nom, prenom);
		this.diplome = diplome;
	}

	public Ingenieur(int id, String nom, String prenom, String diplome) {
		super(id, nom, prenom);
		this.diplome = diplome;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	@Override
	public String toString() {
		return "Ingenieur [diplome=" + diplome + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}


	
	
	
}
