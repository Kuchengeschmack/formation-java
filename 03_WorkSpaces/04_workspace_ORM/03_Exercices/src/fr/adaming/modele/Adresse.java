package fr.adaming.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="adresses")
public class Adresse {
	
	// Déclaration des attribus
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adr")
	private int id;
	private String rue;
	private String ville;
	private int codePostal;
	
	// Transformation de l'association UML en Java
	@OneToOne(mappedBy = "adresse")
	private Employe employe;
	
	// Déclaration des constructeurs
	public Adresse() {
		super();
	}
	public Adresse(String rue, String ville, int codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	public Adresse(int id, String rue, String ville, int codePostal) {
		super();
		this.id = id;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	// Déclaration des accesseurs et des modificateurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	// Rédéfinition du toString
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	

	
}
