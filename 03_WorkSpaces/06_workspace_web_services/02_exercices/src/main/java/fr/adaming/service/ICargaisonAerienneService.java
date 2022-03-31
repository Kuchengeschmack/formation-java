package fr.adaming.service;

import fr.adaming.entities.CargaisonAerienne;

public interface ICargaisonAerienneService {

	// Déclaration des méthodes CRUD

	// Save
	public void save(CargaisonAerienne entite);

	// Update
	public void update(CargaisonAerienne entite);

	// Get
	public CargaisonAerienne getById(int id);

	// Delete
	public void delete(CargaisonAerienne entite);
}
