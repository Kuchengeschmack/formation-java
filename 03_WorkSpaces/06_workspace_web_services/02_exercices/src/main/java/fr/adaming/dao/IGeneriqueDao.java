package fr.adaming.dao;

import java.io.Serializable;

public interface IGeneriqueDao<T extends Serializable> {

	// Déclaration du setGeneric

	public void setGeneric(Class<T> generic);

	// Déclaration des méthodes CRUD

	// Save
	public void save(T entite);

	// Update
	public void update(T entite);

	// Get
	public T getById(int id);

	// Delete
	public void delete(T entite);
}
