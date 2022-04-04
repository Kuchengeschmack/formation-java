package fr.adaming.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.model.Etudiant;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

	// Transformation de l'association UML en JAVA
	@Autowired
	private IEtudiantDao etudiantDao;

	@Override
	public List<Etudiant> getAllEtudiants() {

		return etudiantDao.findAll();
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {

		return etudiantDao.save(eIn);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant eIn) {

		return etudiantDao.save(eIn); // On réutilise save
	}

	@Override
	public void deleteEtudiantById(int id) {

		etudiantDao.deleteById(id);

	}

	@Override
	public Etudiant getEtudiantById(int id) {

		Optional<Etudiant> etudiantOpt = etudiantDao.findById(id);
		try {

			return etudiantOpt.get(); // Si l'étudiant n'est pas trouvé, retourne null

		} catch (NoSuchElementException ex) {

			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public Etudiant getEtudiantByNomAndPrenom(String nom, String prenom) {

		return etudiantDao.findByNomAndPrenom(nom, prenom);
	}

	@Override
	public List<Etudiant> getEtudiantByAge(int age) {

		return etudiantDao.searchEtudiant(age);
	}

}
