package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;


@Service //pour que le conteneur spring IoC puisse l'instancier comme  Service
@Transactional // pour la gestion des transtion
public class EtudiantServiceImpl implements IEtudiantService{

	// Transformation de l'association UML en JAVA
	@Autowired //pour injecter le EtudiantDao instcié par le conteneur spring IoC grace à @Repository
	private IEtudiantDao etudiantDao;
	
	@Override
	public List<Etudiant> getAllEtudiants(Formateur fIn) {

		// appel de la methode dao
		return etudiantDao.getAllEtudiants(fIn);
	}

	@Override
	public Etudiant addEtudiant(Formateur fIn, Etudiant eIn) {
		// TODO Auto-generated method stub
		return null;
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
