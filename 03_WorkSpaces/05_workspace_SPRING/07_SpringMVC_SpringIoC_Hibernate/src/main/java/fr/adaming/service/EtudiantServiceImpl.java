package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Service // Pour que le conteneur Spring IoC puisse l'instancier comme Service
@Transactional // Pour la gestion des transactions (on évite de générer plusieurs transaction
				// qui auraient été générées dans la DAO)
public class EtudiantServiceImpl implements IEtudiantService {

	// Transformation de l'association UML en Java
	@Autowired // Pour injecter l'EtudiantDao instancié par le conteneur Spring IoC grâce à
				// @Repository
	private IEtudiantDao etudiantDao;

	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {

		// Appel de la méthode DAO
		return etudiantDao.getAllEtudiant(fIn);
	}

	@Override
	public Etudiant addEtudiant(Formateur fIn, Etudiant eIn) {

		// Lier les objets en Java
		eIn.setFormateur(fIn);

		// Appel de la méthode Dao
		return etudiantDao.addEtudiant(eIn);
	}

	@Override
	public int updateEtudiant(Formateur fIn, Etudiant eIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteEtudiant(Formateur fIn, Etudiant eIn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Etudiant getEtudiantById(Formateur fIn, Etudiant eIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
