package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GeneriqueDaoImpl<T extends Serializable> implements IGeneriqueDao<T> {

	protected Class<T> generic;

	@Autowired
	protected SessionFactory sf; // protected afin de récupérer le bean dans les classes filles

	// Initialiser la classe T
	public final void setGeneric(Class<T> generic) {
		this.generic = generic;
	}

	// Déclaration des méthodes CRUD

	// Save
	public T save(T entite) {
		Session s = sf.getCurrentSession();
		s.save(entite);
		return entite;
	}

	// Update
	public T update(T entite) {
		Session s = sf.getCurrentSession();
		s.update(entite);
		return entite;
	}

	// Get
	public T getById(Long id) {
		Session s = sf.getCurrentSession();
		return s.get(generic, id);
	}

	// Delete
	@SuppressWarnings("rawtypes")
	public int delete(Long id) {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "DELETE FROM " + generic.getSimpleName() + " AS entite WHERE entite.id=:pId";

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pId", id);

		// Exécuter la requête et obtenir le résultat
		int verif = query.executeUpdate();

		// Retourner la vérifiction
		return verif;
	}

	// Déclaration de méthodes supplémentaires au CRUD

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> list() {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "FROM " + generic.getSimpleName();

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Exécuter la requête et obtenir le résultat
		List<T> listeEntite = query.list();

		// Retourner la vérifiction
		return listeEntite;

	}

}
