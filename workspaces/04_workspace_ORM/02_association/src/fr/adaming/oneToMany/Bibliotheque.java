package fr.adaming.oneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "librairies")
public class Bibliotheque {

	// D�claration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_b")
	private int id;
	private String nom;
	private String adresse;

	// Transformation de l'association UML en Java
	@OneToMany(mappedBy = "bibliotheque", cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	// L'attribut cascade sert � propager les op�rations qui sont faites sur la bliotheque sur les livres
	// L'attribut fetch sert � sp�cifier le mode de chargmement des objets de l'association
	// - Lazy : chargement paresseux, il va charger les objets associ�s lors de leur utilisation
	// - Eager : il va charger les objets de l'association au moment du chargement d'un objet
	private List<Livre> livres;

	// D�claration des constructeurs
	public Bibliotheque() {
		super();
	}

	public Bibliotheque(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public Bibliotheque(int id, String nom, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}

	// Getters and setters
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	// Red�finition de toString
	@Override
	public String toString() {
		return "Bibliotheque [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}

}
