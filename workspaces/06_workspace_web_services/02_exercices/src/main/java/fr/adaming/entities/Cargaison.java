package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cargaisons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Cette annotation permet de gérer l'héritage en JPA (on spécifie
														// la stratégie pour la gestion de l'héritage

// Les différentes stratégies : SINGLE_TABLE, TABLE_PER_CLASS, JOIN

@DiscriminatorColumn(name = "categorie") // Cette annotation permet de créer une colonne dans la table pour pouvoir
											// distinguer le type de l'enregistrement

@SuppressWarnings("serial")
public abstract class Cargaison implements Serializable {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;
	@Column(name = "reference")
	protected String reference;
	@Column(name = "distance_parcours")
	protected Double distanceParcours; // En km

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_livraison")
	protected Date dateLivraison; // Format AAAA-MM-JJ

	// Transformation de l'association UML en Java

	@OneToMany(mappedBy = "cargaison", cascade = CascadeType.ALL) // LAZY pour éviter les
																	// références cycliques
	@JsonIgnore // Pour éviter la boucle dans la génération du json
	protected List<Marchandise> marchandises;

	// Déclaration des constructeurs

	public Cargaison() {
		super();
	}

	public Cargaison(Long id) {
		super();
		this.id = id;
	}

	public Cargaison(String reference, Double distanceParcours, Date dateLivraison) {
		super();
		this.reference = reference;
		this.distanceParcours = distanceParcours;
		this.dateLivraison = dateLivraison;
	}

	public Cargaison(Long id, String reference, Double distanceParcours, Date dateLivraison) {
		super();
		this.id = id;
		this.reference = reference;
		this.distanceParcours = distanceParcours;
		this.dateLivraison = dateLivraison;
	}

	// Déclaration des getters et des setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getDistanceParcours() {
		return distanceParcours;
	}

	public void setDistanceParcours(Double distanceParcours) {
		this.distanceParcours = distanceParcours;
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
