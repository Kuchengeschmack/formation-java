package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Cargaison;

public interface ICargaisonService {

	// Déclaration des méthodes CRUD

	// Save
	public Cargaison save(Cargaison entite);

	// Update
	public Cargaison update(Cargaison entite);

	// Get
	public Cargaison getById(Long id);

	// Delete
	public int delete(Long id);

	// Déclaration des méthodes supplémentaires au CRUD

	public List<Cargaison> list();
}
