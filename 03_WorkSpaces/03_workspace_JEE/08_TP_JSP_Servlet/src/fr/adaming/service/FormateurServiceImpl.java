package fr.adaming.service;

import fr.adaming.dao.FormateurDaoImpl;
import fr.adaming.dao.IFormateurDao;
import fr.adaming.entites.Formateur;

public class FormateurServiceImpl implements IFormateurService {

	// transformation d'association UML en Java
	private IFormateurDao fDao = new FormateurDaoImpl();
	
	@Override
	public Formateur isExist(Formateur fIn) {

		// Appel de la méthode service
		return fDao.isExist(fIn);
	}

}
