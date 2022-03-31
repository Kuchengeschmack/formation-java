package fr.adaming.service;

import fr.adaming.entities.CargaisonRoutiere;

public interface ICargaisonRoutiereService {

	// Déclaration des méthodes CRUD

	// Save
	public void save(CargaisonRoutiere entite);

	// Update
	public void update(CargaisonRoutiere entite);

	// Get
	public CargaisonRoutiere getById(int id);

	// Delete
	public void delete(CargaisonRoutiere entite);
}
