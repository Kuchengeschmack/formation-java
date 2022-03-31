package fr.adaming.service;

import fr.adaming.entities.Marchandise;

public interface IMarchandiseService {

	// Déclaration des méthodes CRUD

	// Save
	public void save(Marchandise entite);

	// Update
	public void update(Marchandise entite);

	// Get
	public Marchandise getById(int id);

	// Delete
	public void delete(Marchandise entite);
}
