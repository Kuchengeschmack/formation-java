package fr.adaming.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EtudiantDaoImpl implements IEtudiantDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Etudiant getEtudiantById(int id) {

		Session s = sf.getCurrentSession();

		return s.get(Etudiant.class, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Etudiant> getAllEtudiants() {

		Session s = sf.getCurrentSession();

		Query req = s.createQuery("FROM Etudiant");

		return req.list();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {

		Session s = sf.getCurrentSession();

		s.save(eIn);

		return eIn;
	}

	@Override
	public void updateEtudiant(Etudiant eIn) {

		Session s = sf.getCurrentSession();

		s.update(eIn);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public int deleteEtudiant(int id) {

		// Récupérer la session
		Session s = sf.getCurrentSession();

		// Récupérer la requête HQL
		String req = "DELETE FROM Etudiant AS e WHERE e.id=:pId";

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Donner la valeur du paramètre
		query.setParameter("pId", id);

		// Exécuter la requête et obtenir le résultat
		int verif = query.executeUpdate();

		// Retourner la vérifiction
		return verif;
	}

}
