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

	@Autowired // Pour l'injection des d�pendances (Collaborateur)
	private SessionFactory sf;

	@Override
	public Formateur getFormateurByMail(String mail) {

		// r�cup�rer la session hibernate
		Session s = sf.getCurrentSession();

		// Ecrire la requ�te HQL
		String req = "FROM Formateur as f WHERE f.mail=:pMail";

		// R�cup�rer l'objet Query
		Query query = s.createQuery(req);

		// Passage des param�tres
		query.setParameter("pMail", mail);

		// Executer la requ�te HQL
		return (Formateur) query.uniqueResult();
	}

}
