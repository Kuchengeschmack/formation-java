package fr.adaming.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etudiants")
public class Etudiant {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_e")
	private int id;
	private String nom;
	
	// Transformation de l'association UML en Java
	@ManyToMany(mappedBy = "etudiants")
	private List<Matiere> matieres;

	public Etudiant() {
		super();
	}

	public Etudiant(String nom) {
		super();
		this.nom = nom;
	}

	public Etudiant(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

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

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
