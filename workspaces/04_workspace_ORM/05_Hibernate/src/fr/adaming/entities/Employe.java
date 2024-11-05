package fr.adaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity // Cette annotation permet de rendre la classe persistante, c�d qu'elle sera
		// associ�e � une table dans la BDD
// C'est la seule annotation obligatoire

@Table(name = "employes") // Pour donner le nom � la table au lieu d'utiliser le nom par d�faut

public class Employe {

	// D�claration des attributs

	@Id // Permet de sp�cifier l'attribut associ� � la clef primaire de la table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Sp�cifier la strat�gie utilis�e pour g�n�rer la clef primaire
	// IDENTITY ====> auto_increment
	private int id;

	@Column(name = "nom_e") // Cette annotation permet de renommer la colonne associ�e � cet attribut
	private String nom;
	private String prenom;
	private Double salaire;

	/**
	 * Les attributs qui ont des getters et setters non-static seront pris en compte
	 */

	// D�claration des constructeurs

	public Employe() {
		super();
	}

	public Employe(String nom, String prenom, Double salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}

	public Employe(int id, String nom, String prenom, Double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}

	// D�claration des getters et setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
	}

}
