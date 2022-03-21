package fr.adaming.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voitures")
public class Voiture {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_v")
	private int id;
	private String marque;
	private String modele;

	// Transformation de l'association UML en Java
	@OneToOne // L'annotation pour mapper une association 1 <--> 1
	@JoinColumn(name = "p_id", referencedColumnName = "id_p")
	private Personne proprietaire;

	// Déclaration des constructeurs
	public Voiture() {
		super();
	}

	public Voiture(String marque, String modele) {
		super();
		this.marque = marque;
		this.modele = modele;
	}

	public Voiture(int id, String marque, String modele) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
	}

	// Déclaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Personne getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}

	// Redéfinition de toString
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", modele=" + modele + ", proprietaire=" + proprietaire
				+ "]";
	}

}
