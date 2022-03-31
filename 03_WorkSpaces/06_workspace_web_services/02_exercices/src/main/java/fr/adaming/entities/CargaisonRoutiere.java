package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "cargaisons_routieres")

@XmlRootElement // Permet la sérialisation/désérialisation d'un objet Java en XML. C'est la
				// seule annotation obligatoire de JAXB
@XmlAccessorType(XmlAccessType.FIELD) // Pour que JAXB prenne les annotations mises sur les attributs

@SuppressWarnings("serial")
public class CargaisonRoutiere extends Cargaison implements Serializable {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double tempCons; // Température de conservation en °C

	// Transformation de l'association UML en Java

	@Autowired
	private List<Marchandise> marchandises;

	// Déclaration des constructeurs

	public List<Marchandise> getMarchandises() {
		return marchandises;
	}

	public void setMarchandises(List<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}

	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(String reference, Double distanceParcours, Date dateLivraison, Double tempCons) {
		super(reference, distanceParcours, dateLivraison);
		this.tempCons = tempCons;
	}

	public CargaisonRoutiere(Long id, String reference, Double distanceParcours, Date dateLivraison, Double tempCons) {
		super(id, reference, distanceParcours, dateLivraison);
		this.tempCons = tempCons;
	}

	// Déclaration des getters et des setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTempCons() {
		return tempCons;
	}

	public void setTempCons(Double tempCons) {
		this.tempCons = tempCons;
	}

}
