package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Repository // pour que le conteneur spring IoC puisse l'instancier comme Doa
public class EtudiantDaoImpl implements IEtudiantDao {

	@Autowired // pour injecter le sessionFactoryBean instcié par le conteneur spring IoC
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiants(Formateur fIn) {

		// recuperer le session Hibernate
		Session s = sf.getCurrentSession();

		// ecrire la reqte HQL
		String req = "FROM Etudiant as e WHERE e.formateur.id=:pId";

		// recuperer le Query
		Query query = s.createQuery(req);

		// passage des params de la requete HQL
		query.setParameter("pId", fIn.getId());

		return query.list();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEtudiant(Etudiant eIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteEtudiant(Etudiant eIn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Etudiant getEtudiantById(Etudiant eIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
