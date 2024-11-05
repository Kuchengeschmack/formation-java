package fr.adaming.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "tech")
public class Technicien extends Personne {

	private String poste;

	public Technicien() {
		super();
	}

	public Technicien(String nom, String prenom, String poste) {
		super(nom, prenom);
		this.poste = poste;
	}

	public Technicien(int id, String nom, String prenom, String poste) {
		super(id, nom, prenom);
		this.poste = poste;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	@Override
	public String toString() {
		return "Technicien [poste=" + poste + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
