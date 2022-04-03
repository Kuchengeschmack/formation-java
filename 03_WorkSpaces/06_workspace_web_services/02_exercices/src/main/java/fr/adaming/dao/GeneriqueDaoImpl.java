package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GeneriqueDaoImpl<T extends Serializable> implements IGeneriqueDao<T> {

	private Class<T> generic;

	@Autowired
	private SessionFactory sf;

	// Initialiser la classe T
	public final void setGeneric(Class<T> generic) {
		this.generic = generic;
	}

	// Déclaration des méthodes CRUD

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
	@SuppressWarnings("rawtypes")
	public int delete(Long id) {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "DELETE FROM :pEntite AS entite WHERE entite.id=:pId";

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pEntite", generic.getName()); // Récupérer le nom de la classe entité
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
		String req = "SELECT FROM :pEntite";

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pEntite", generic.getName()); // Récupérer le nom de la classe entité

		// Exécuter la requête et obtenir le résultat
		List<T> listeEntite = query.list();

		// Retourner la vérifiction
		return listeEntite;

	}

}
