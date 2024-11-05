package fr.adaming.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value = "routiere")

@XmlRootElement // Permet la sérialisation/désérialisation d'un objet Java en XML. C'est la
				// seule annotation obligatoire de JAXB
@XmlAccessorType(XmlAccessType.FIELD) // Pour que JAXB prenne les annotations mises sur les attributs

@SuppressWarnings("serial")
public class CargaisonRoutiere extends Cargaison {

	// Déclaration des attributs

	@Column(name = "temp_cons")
	private Double tempCons; // Température de conservation en °C

	// Déclaration des constructeurs

	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(Long id) {
		super(id);
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

	public Double getTempCons() {
		return tempCons;
	}

	public void setTempCons(Double tempCons) {
		this.tempCons = tempCons;
	}

}
