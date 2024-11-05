package fr.adaming.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projets")
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proj")
	private int id;
	private String nom; // Nom du projet
	
	// Transformation de l'association UML en Java
	@ManyToMany(mappedBy = "projets")
	private List<Employe> participants;

	// Déclaration des constructeurs
	public Projet() {
		super();
	}

	public Projet(String nom) {
		super();
		this.nom = nom;
	}

	public Projet(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	// Déclaration des modificateurs et des accesseurs
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

	public List<Employe> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Employe> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
