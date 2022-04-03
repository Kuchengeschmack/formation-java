package fr.adaming.service;

import java.util.List;

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
	public int delete(Long id);

	// Déclaration des méthodes supplémentaires au CRUD

	public List<CargaisonAerienne> list();
}
