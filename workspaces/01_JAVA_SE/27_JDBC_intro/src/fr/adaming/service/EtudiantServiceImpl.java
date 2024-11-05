package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.EtudiantDaoImpl;
import fr.adaming.dao.IEtudiantDao;
import fr.adaming.modele.Etudiant;

public class EtudiantServiceImpl implements IEtudiantService {

	// Transformation de l'UML en Java
	private IEtudiantDao eDao = new EtudiantDaoImpl();

	@Override
	public void addEtudiantService(Etudiant eIn) {

		// appeler la méthode de la couche DAO
		eDao.addEtudiantDao(eIn);
	}

	@Override
	public int updateEtudiantService(Etudiant eIn) {
		// Appeler la méthode de couche DAO
		int verif = eDao.updateEtudiantDao(eIn);
		return verif;
	}

	public int deleteEtudiantService(int eId) {
		int verif = eDao.deleteEtudiantDao(eId);
		return verif;
	}

	public List<Etudiant> getAllEtudiantsService() {
		List<Etudiant> liste = eDao.getAllEtudiantsDao();
		if (liste != null) {
			return liste;
		}
		return null;
	}

	public Etudiant getEtudiantService(int eId) {
		Etudiant e = eDao.getEtudiantDao(eId);
		if(e != null) {
			return e;
		}
		return null;
	}
}
