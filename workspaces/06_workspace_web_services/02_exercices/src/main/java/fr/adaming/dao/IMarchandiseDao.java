package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Cargaison;
import fr.adaming.entities.Marchandise;

public interface IMarchandiseDao extends IGeneriqueDao<Marchandise> {

	// Recherche de marchandise par cargaison
	public List<Marchandise> rechercheMarchandise(Cargaison cargIn);

	// Recherche de marchandise par mot-clef
	public List<Marchandise> rechercheMarchandise(String motClef);

}
