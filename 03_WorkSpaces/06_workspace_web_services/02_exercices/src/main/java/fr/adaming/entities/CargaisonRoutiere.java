package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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

	private Double tempCons; // Température de conservation en °C

	// Transformation de l'association UML en Java

	@Autowired
	private List<Marchandise> marchandises;

	// Déclaration des constructeurs

	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(Double distanceParcours, Date dateLivraison, Double tempCons) {
		super(distanceParcours, dateLivraison);
		this.tempCons = tempCons;
	}

	public CargaisonRoutiere(String reference, Double distanceParcours, Date dateLivraison, Double tempCons) {
		super(reference, distanceParcours, dateLivraison);
		this.tempCons = tempCons;
	}

	// Déclaration des getters et des setters

	public Double getTempCons() {
		return tempCons;
	}

	public void setTempCons(Double tempCons) {
		this.tempCons = tempCons;
	}

}
