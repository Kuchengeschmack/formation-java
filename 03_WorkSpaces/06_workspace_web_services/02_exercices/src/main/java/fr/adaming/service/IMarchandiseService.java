package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Cargaison;
import fr.adaming.entities.Marchandise;

public interface IMarchandiseService {

	// Déclaration des méthodes CRUD

	// Save
	public Marchandise save(Marchandise entite);

	// Update
	public Marchandise update(Marchandise entite);

	// Get
	public Marchandise getById(Long id);

	// Delete
	public int delete(Long id);

	// Déclaration des méthodes supplémentaires au CRUD

	public List<Marchandise> list();

	// Recherche de marchandise par cargaison
	public List<Marchandise> rechercheMarchandise(Cargaison cargIn);

	// Recherche de marchandise par mot-clef
	public List<Marchandise> rechercheMarchandise(String motClef);
}
