package fr.adaming.dao;

import fr.adaming.entities.Cargaison;
import fr.adaming.entities.Marchandise;

public interface IMarchandiseDao extends IGeneriqueDao<Marchandise> {

	// Recherche de marchandise par cargaison
	public Marchandise rechercheMarchandise(Cargaison cargIn);

	// Recherche de marchandise par mot-clef
	public Marchandise rechercheMarchandise(String motClef);

}
