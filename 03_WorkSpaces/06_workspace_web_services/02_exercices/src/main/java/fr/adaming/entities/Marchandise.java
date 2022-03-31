package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "marchandises")

@XmlRootElement // Permet la sérialisation/désérialisation d'un objet Java en XML. C'est la
				// seule annotation obligatoire de JAXB
@XmlAccessorType(XmlAccessType.FIELD) // Pour que JAXB prenne les annotations mises sur les attributs

@SuppressWarnings("serial")
public class Marchandise implements Serializable {

	// Déclaration des attributs

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num; // Numéro auto-incrémenté
	private String nom; // Le nom de la marchandise
	private Double poids;
	private Double vol;

	// Déclaration des constructeurs

	public Marchandise() {
		super();
	}

	public Marchandise(String nom, Double poids, Double vol) {
		super();
		this.nom = nom;
		this.poids = poids;
		this.vol = vol;
	}

	public Marchandise(Long num, String nom, Double poids, Double vol) {
		super();
		this.num = num;
		this.nom = nom;
		this.poids = poids;
		this.vol = vol;
	}

	// Déclaration des getters et de setters

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	public Double getVol() {
		return vol;
	}

	public void setVol(Double vol) {
		this.vol = vol;
	}

}
