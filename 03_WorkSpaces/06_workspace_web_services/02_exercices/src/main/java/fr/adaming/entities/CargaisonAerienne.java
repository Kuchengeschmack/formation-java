package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "cargaisons_aeriennes")

@XmlRootElement // Permet la sérialisation/désérialisation d'un objet Java en XML. C'est la
				// seule annotation obligatoire de JAXB
@XmlAccessorType(XmlAccessType.FIELD) // Pour que JAXB prenne les annotations mises sur les attributs

@SuppressWarnings("serial")
public class CargaisonAerienne extends Cargaison implements Serializable {

	// Déclaration des attributs

	public static final Double POIDS_MAX = 0.; // Poids maximal en kg, ne doit pas être dépassé

	// Transformation de l'association UML en Java

	@Autowired
	private List<Marchandise> marchandises;
}
