package fr.adaming.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "matieres")
public class Matiere {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_m")
	private int id;
	private String titre;

	// Transformation de l'association UML en Java
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "table_assoc", joinColumns = @JoinColumn(name = "m_id"), inverseJoinColumns = @JoinColumn(name = "e_id"))
	private List<Etudiant> etudiants;

	public Matiere() {
		super();
	}

	public Matiere(String titre) {
		super();
		this.titre = titre;
	}

	public Matiere(int id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", titre=" + titre + ", etudiants=" + etudiants + "]";
	}

}
