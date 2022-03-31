package fr.adaming.service;

import fr.adaming.entities.CargaisonAerienne;

public interface ICargaisonAerienneService {

	// Déclaration des méthodes CRUD

	// Save
	public CargaisonAerienne save(CargaisonAerienne entite);

	// Update
	public void update(CargaisonAerienne entite);

	// Get
	public CargaisonAerienne getById(Long id);

	// Delete
	public void delete(Long id);
}
