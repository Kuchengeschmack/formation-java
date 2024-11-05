package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IGeneriqueDao<T extends Serializable> {

	// Déclaration du setGeneric

	public void setGeneric(Class<T> generic);

	// Déclaration des méthodes CRUD

	// Save
	public T save(T entite);

	// Update
	public T update(T entite);

	// Get
	public T getById(Long id);

	// Delete
	public int delete(Long id);

	// Déclaration de méthodes supplémentaires au CRUD

	public List<T> list();

}
