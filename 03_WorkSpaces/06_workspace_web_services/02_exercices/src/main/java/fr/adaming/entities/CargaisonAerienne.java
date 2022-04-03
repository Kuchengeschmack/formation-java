package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;

	public static final Double POIDS_MAX = 0.; // Poids maximal en kg, ne doit pas être dépassé

	// Transformation de l'association UML en Java

	@OneToMany(mappedBy = "cargaison")
	private List<Marchandise> marchandises;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public List<Marchandise> getMarchandises() {
		return marchandises;
	}

	public void setMarchandises(List<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}
	
	
}
