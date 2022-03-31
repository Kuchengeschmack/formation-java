package fr.adaming.service;

import fr.adaming.entities.Marchandise;

public interface IMarchandiseService {

	// Déclaration des méthodes CRUD

	// Save
	public Marchandise save(Marchandise entite);

	// Update
	public void update(Marchandise entite);

	// Get
	public Marchandise getById(Long id);

	// Delete
	public Long delete(Long id);
}
