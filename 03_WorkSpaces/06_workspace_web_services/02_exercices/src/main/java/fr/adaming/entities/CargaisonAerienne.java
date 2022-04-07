package fr.adaming.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue(value = "aerienne")

@XmlRootElement // Permet la sérialisation/désérialisation d'un objet Java en XML. C'est la
				// seule annotation obligatoire de JAXB
@XmlAccessorType(XmlAccessType.FIELD) // Pour que JAXB prenne les annotations mises sur les attributs

@SuppressWarnings("serial")
public class CargaisonAerienne extends Cargaison {

	// Déclaration des attributs

	@Column(name = "poids_max")
	public static final Double POIDS_MAX = 1000.; // Poids maximal en kg, ne doit pas être dépassé

	// Déclaration des constructeurs

	public CargaisonAerienne() {
		super();
	}

	public CargaisonAerienne(Long id) {
		super(id);
	}

	public CargaisonAerienne(String reference, Double distanceParcours, Date dateLivraison) {
		super(reference, distanceParcours, dateLivraison);
	}

	public CargaisonAerienne(Long id, String reference, Double distanceParcours, Date dateLivraison) {
		super(id, reference, distanceParcours, dateLivraison);
	}

	// Déclaration des getters et des setters

	// On vérifie que le poids total n'est pas dépassé, sinon la liste est null
	@Override
	public void setMarchandises(List<Marchandise> marchandises) {

		// Calcul du poids total
		Double poidsTotal = 0.;
		for (Marchandise m : marchandises) {
			poidsTotal += m.getPoids();
		}

		// Si le poids est supérieur au POIDS_MAX, marchandises = null
		if (poidsTotal > POIDS_MAX) {
			this.marchandises = null;
		} else {
			this.marchandises = marchandises;
		}
	}

}
