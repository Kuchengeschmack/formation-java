package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Repository // Pour que la classe soit reconnue comme une classe DAO
public class FormateurDaoImpl implements IFormateurDao {

	@Autowired // Pour l'injection des dépendances (Collaborateur)
	private SessionFactory sf;

	@Override
	public Formateur getFormateurByMail(String mail) {

		// récupérer la session hibernate
		Session s = sf.getCurrentSession();

		// Ecrire la requête HQL
		String req = "FROM Formateur as f WHERE f.mail=:pMail";

		// Récupérer l'objet Query
		Query query = s.createQuery(req);

		// Passage des paramètres
		query.setParameter("pMail", mail);

		// Executer la requête HQL
		return (Formateur) query.uniqueResult();
	}

}
