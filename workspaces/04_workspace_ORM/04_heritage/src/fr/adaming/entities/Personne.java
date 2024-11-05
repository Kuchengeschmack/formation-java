package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//@Entity
//@Table(name = "personnes")
//@Inheritance(strategy = InheritanceType.JOINED) // Cette annotation permet de gérer l'héritage en JPA (on spécifie
//														// la stratégie pour la gestion de l'héritage
///*
//* Les différentes stratégies
//* * SINGLE_TABLE
//* * TABLE_PER_CLASS
//* * JOIN
//*/
//
//@DiscriminatorColumn(name = "categorie") // Cette annotation permet de créer une colonne dans la table pour pouvoir
//											// distinguer le type de l'enregistrement
//@DiscriminatorValue(value = "per")

@MappedSuperclass
public abstract class Personne implements Serializable {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String nom;
	protected String prenom;

	// Déclaration des constructeurs
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	// Déclaration des getter et setters
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
