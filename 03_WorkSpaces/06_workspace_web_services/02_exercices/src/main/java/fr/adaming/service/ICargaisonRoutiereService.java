package fr.adaming.service;

import fr.adaming.entities.CargaisonRoutiere;

public interface ICargaisonRoutiereService {

	// Déclaration des méthodes CRUD

	// Save
	public CargaisonRoutiere save(CargaisonRoutiere entite);

	// Update
	public void update(CargaisonRoutiere entite);

	// Get
	public CargaisonRoutiere getById(Long id);

	// Delete
	public void delete(Long id);
}
