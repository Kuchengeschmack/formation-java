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
public class MarchandiseDaoImpl extends GeneriqueDaoImpl<Marchandise> implements IMarchandiseDao {

	@Autowired
	private SessionFactory sf;

	// Recherche de marchandise par cargaison
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Marchandise> rechercheMarchandise(Cargaison cargIn) {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "FROM Marchandise AS m WHERE m.cargaison.id=:pId"; // Réfléchir à la requête

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pId", cargIn.getId()); // Récupérer le nom de la classe entité

		// Exécuter la requête et obtenir le résultat
		List<Marchandise> listeEntite = query.list();

		// Retourner la vérifiction
		return listeEntite;
	}

	// Recherche de marchandise par mot-clef
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Marchandise> rechercheMarchandise(String motClef) {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "FROM Marchandise AS m WHERE m.nom LIKE :pMotClef"; // Réfléchir à la requête

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pMotClef", "%" + motClef + "%"); // Récupérer le mot clef et construire la requête LIKE

		// Exécuter la requête et obtenir le résultat
		List<Marchandise> listeEntite = query.list();

		// Retourner la vérifiction
		return listeEntite;
	}

}
