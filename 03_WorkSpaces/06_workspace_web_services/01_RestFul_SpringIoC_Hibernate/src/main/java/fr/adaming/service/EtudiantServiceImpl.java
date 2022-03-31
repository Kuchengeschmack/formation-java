package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.entities.Etudiant;

@Service
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

	// Transformation de l'association UML en Java
	@Autowired
	private IEtudiantDao etudiantDao;

	@Override
	public Etudiant getEtudiantById(int id) {

		return etudiantDao.getEtudiantById(id);
	}

	@Override
	public List<Etudiant> getAllEtudiants() {

		return etudiantDao.getAllEtudiants();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {

		return etudiantDao.addEtudiant(eIn);
	}

	@Override
	public void updateEtudiant(Etudiant eIn) {

		etudiantDao.updateEtudiant(eIn);

	}

	@Override
	public int deleteEtudiant(int id) {

		return etudiantDao.deleteEtudiant(id);
	}

}
