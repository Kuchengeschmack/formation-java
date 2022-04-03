package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Cargaison;
import fr.adaming.entities.Marchandise;

@Repository
public class MarchandiseDaoImpl extends GeneriqueDaoImpl<Marchandise> {

	@Autowired
	private SessionFactory sf;

	// Recherche de marchandise par cargaison
	public Marchandise rechercheMarchandise(Cargaison cargIn) {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "SELECT FROM Marchandise AS c WHERE c."; // Réfléchir à la requête

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pEntite", generic.getName()); // Récupérer le nom de la classe entité

		// Exécuter la requête et obtenir le résultat
		List<T> listeEntite = query.list();

		// Retourner la vérifiction
		return listeEntite;
	}

	// Recherche de marchandise par mot-clef
	public Marchandise rechercheMarchandise(String motClef) {
		return null;
	}
}
