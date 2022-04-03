package fr.adaming.entities;

import java.util.Date;
import java.util.List;

public abstract class Cargaison {

	// Déclaration des attributs
	protected Long id;
	protected String reference;

	protected Double distanceParcours; // En km
	protected Date dateLivraison; // Format AAAA-MM-JJ

	// Transformation de l'association UML en Java

	protected List<Marchandise> marchandises;

	// Déclaration des constructeurs

	public Cargaison() {
		super();
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
