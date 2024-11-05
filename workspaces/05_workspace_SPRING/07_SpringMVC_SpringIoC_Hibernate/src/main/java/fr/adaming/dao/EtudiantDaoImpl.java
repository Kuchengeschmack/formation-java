package fr.adaming.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Repository // Pour que le conteneur IoC puisse l'instancier comme Dao
public class EtudiantDaoImpl implements IEtudiantDao {

	@Autowired // Pour injecter le sessionFactoryBean instancié par le conteneur Spring IoC
				// (collaborateur)
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {

		// Récupérer la session Hibernate
		Session s = sf.getCurrentSession(); // Créer une nouvelle session il elle n'existe pas

		// Écrire la requête HQL
		String req = "FROM Etudiant AS e WHERE e.formateur.id=:pId";

		// Récupérer le Query
		Query query = s.createQuery(req);

		// Passage des params de la requête HQL
		query.setParameter("pId", fIn.getId());

		return query.list();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {

		// Récupérer la session hibernate
		Session s = sf.getCurrentSession();

		// Appel de la méthode save de la session pour relier l'objet eIn avec le
		// contexte de la session Hibernate
		s.save(eIn);

		return eIn;
	}

	@Override
	public int updateEtudiant(Etudiant eIn) {

		// Récupérer la session Hibernate
		Session s = sf.getCurrentSession();

		// Écrire la requête HQL
		String req = "UPDATE Etudiant as e SET e.nom=:pNom, e.prenom=:pPrenom, e.dn=:pDate WHERE e.id=:pId AND e.formateur.id=:pIdF";

		// Récupérer l'objet Query pour envoyer la requête HQL

		Query query = s.createQuery(req);

		// Passage des paramètres
		query.setParameter("pNom", eIn.getNom());
		query.setParameter("pPrenom", eIn.getPrenom());
		query.setParameter("pDate", eIn.getDn());
		query.setParameter("pId", eIn.getId());
		query.setParameter("pIdF", eIn.getFormateur().getId());

		// Exécuter la requête HQL
		return query.executeUpdate(); // Retourne le nombre de lignes modifiées
	}

	@Override
	public boolean deleteEtudiant(Etudiant eIn) {

		try {
			Session s = sf.getCurrentSession();

			s.delete(eIn);

			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public Etudiant getEtudiantById(Etudiant eIn) {
		// récupérer la session hibernate
		Session s = sf.getCurrentSession();

		// Ecrire la requête HQL
		String req = "FROM Etudiant as e WHERE e.id=:pId AND e.formateur.id=:pIdF";

		// Récupérer l'objet Query
		Query query = s.createQuery(req);

		// Passage des paramètres
		query.setParameter("pId", eIn.getId());
		query.setParameter("pIdF", eIn.getFormateur().getId());

		// Executer la requête HQL
		return (Etudiant) query.uniqueResult();
	}

}
