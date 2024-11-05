package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.EtudiantDaoImpl;
import fr.adaming.dao.FormateurDaoImpl;
import fr.adaming.dao.IEtudiantDao;
import fr.adaming.dao.IFormateurDao;
import fr.adaming.entites.Etudiant;
import fr.adaming.entites.Formateur;

public class EtudiantServiceImpl implements IEtudiantService {

	// Transformation de l'association UML en Java
	private IEtudiantDao eDao = new EtudiantDaoImpl();

	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {
		// Appel de la méthode Dao
		return eDao.getAllEtudiant(fIn);
	}

	@Override
	public int addEtudiant(Formateur fIn, Etudiant eIn) {

		// Lier les objets en Java
		eIn.setFormateur(fIn);
		return eDao.addEtudiant(eIn);
	}

	@Override
	public int updateEtudiant(Formateur fIn, Etudiant eIn) {

		// Lier les objets en Java
		eIn.setFormateur(fIn);
		return eDao.updateEtudiant(eIn);
	}

	@Override
	public int deleteEtudiantById(Formateur fIn, Etudiant eIn) {
		// Lier les objets en Java
		eIn.setFormateur(fIn);
		return eDao.deleteEtudiantById(eIn);
	}

	@Override
	public Etudiant getEtudiantById(Formateur fIn, Etudiant eIn) {
		// Lier les objets en Java
		eIn.setFormateur(fIn);
		return eDao.getEtudiantById(eIn);
	}

}
