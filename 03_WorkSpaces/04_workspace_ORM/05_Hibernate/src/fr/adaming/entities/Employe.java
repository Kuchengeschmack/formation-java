package fr.adaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity // Cette annotation permet de rendre la classe persistante, càd qu'elle sera
		// associée à une table dans la BDD
// C'est la seule annotation obligatoire

@Table(name = "employes") // Pour donner le nom à la table au lieu d'utiliser le nom par défaut

public class Employe {

	// Déclaration des attributs

	@Id // Permet de spécifier l'attribut associé à la clef primaire de la table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifier la stratégie utilisée pour générer la clef primaire
	// IDENTITY ====> auto_increment
	private int id;

	@Column(name = "nom_e") // Cette annotation permet de renommer la colonne associée à cet attribut
	private String nom;
	private String prenom;
	private Double salaire;

	/**
	 * Les attributs qui ont des getters et setters non-static seront pris en compte
	 */

	// Déclaration des constructeurs

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

	// Déclaration des getters et setters

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
