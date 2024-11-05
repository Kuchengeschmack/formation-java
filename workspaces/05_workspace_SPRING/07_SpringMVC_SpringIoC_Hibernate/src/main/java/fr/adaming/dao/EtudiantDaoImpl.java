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

	@Autowired // Pour injecter le sessionFactoryBean instanci� par le conteneur Spring IoC
				// (collaborateur)
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {

		// R�cup�rer la session Hibernate
		Session s = sf.getCurrentSession(); // Cr�er une nouvelle session il elle n'existe pas

		// �crire la requ�te HQL
		String req = "FROM Etudiant AS e WHERE e.formateur.id=:pId";

		// R�cup�rer le Query
		Query query = s.createQuery(req);

		// Passage des params de la requ�te HQL
		query.setParameter("pId", fIn.getId());

		return query.list();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {

		// R�cup�rer la session hibernate
		Session s = sf.getCurrentSession();

		// Appel de la m�thode save de la session pour relier l'objet eIn avec le
		// contexte de la session Hibernate
		s.save(eIn);

		return eIn;
	}

	@Override
	public int updateEtudiant(Etudiant eIn) {

		// R�cup�rer la session Hibernate
		Session s = sf.getCurrentSession();

		// �crire la requ�te HQL
		String req = "UPDATE Etudiant as e SET e.nom=:pNom, e.prenom=:pPrenom, e.dn=:pDate WHERE e.id=:pId AND e.formateur.id=:pIdF";

		// R�cup�rer l'objet Query pour envoyer la requ�te HQL

		Query query = s.createQuery(req);

		// Passage des param�tres
		query.setParameter("pNom", eIn.getNom());
		query.setParameter("pPrenom", eIn.getPrenom());
		query.setParameter("pDate", eIn.getDn());
		query.setParameter("pId", eIn.getId());
		query.setParameter("pIdF", eIn.getFormateur().getId());

		// Ex�cuter la requ�te HQL
		return query.executeUpdate(); // Retourne le nombre de lignes modifi�es
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
		// r�cup�rer la session hibernate
		Session s = sf.getCurrentSession();

		// Ecrire la requ�te HQL
		String req = "FROM Etudiant as e WHERE e.id=:pId AND e.formateur.id=:pIdF";

		// R�cup�rer l'objet Query
		Query query = s.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", eIn.getId());
		query.setParameter("pIdF", eIn.getFormateur().getId());

		// Executer la requ�te HQL
		return (Etudiant) query.uniqueResult();
	}

}
