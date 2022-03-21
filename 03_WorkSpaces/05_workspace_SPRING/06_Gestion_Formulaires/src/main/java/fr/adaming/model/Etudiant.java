package fr.adaming.model;

import java.io.Serializable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Etudiant implements Serializable {

	// Déclaration des attributs
	private String nom;
	private String prenom;
	private int age;

	// Déclaration des constructeurs
	public Etudiant() {
		super();
	}

	public Etudiant(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	// Déclaration des getters et setters
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
