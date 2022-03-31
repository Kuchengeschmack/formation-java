package fr.adaming.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GeneriqueDaoImpl<T extends Serializable> implements IGeneriqueDao<T> {

	private Class<T> generic;

	@Autowired
	private SessionFactory sf;

	// Initialiser la classe T
	public final void setGeneric(Class<T> generic) {
		this.generic = generic;
	}

	// Save
	public void save(T entite) {
		Session s = sf.getCurrentSession();
		s.save(entite);
	}

	// Update
	public void update(T entite) {
		Session s = sf.getCurrentSession();
		s.update(entite);
	}

	// Get
	public T getById(Long id) {
		Session s = sf.getCurrentSession();
		return s.get(generic, id);
	}

	// Delete
	public void delete(Long id) {
		Session s = sf.getCurrentSession();
		s.delete(s.get(generic, id));
	}

}
