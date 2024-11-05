package fr.adaming.modele;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employes")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emp")
	private int id;
	private String nom;
	private String prenom;
	private int age;
	
	// Transforamtion de l'association UML en Java
	@ManyToOne
	@JoinColumn(name = "ent_id", referencedColumnName = "id_ent")
	private Entreprise entreprise;

	// Transformation de l'association UML en Java
	@OneToOne(cascade = CascadeType.PERSIST) // Cascade pour n'avoir à persister que l'employé
	@JoinColumn(name = "adr_id", referencedColumnName = "id_adr")
	private Adresse adresse;
	
	// Transformation de l'association UML en Java
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "table_assoc", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "proj_id"))
	private List<Projet> projets;
	
	// Transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name = "equ_id", referencedColumnName = "id_equ")
	private Equipe equipe;

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Employe() {
		super();
	}

	public Employe(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Employe(int id, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
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

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

}
