package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormateurDao;
import fr.adaming.entities.Formateur;

@Service
@Transactional
public class FormateurServiceImpl implements IFormateurService {

	// Transformation de l'association UML en Java
	@Autowired
	private IFormateurDao formateurDao;

	@Override
	public Formateur getFormateurByMail(String mail) {

		// Appel de la méthode Dao
		return formateurDao.getFormateurByMail(mail);
	}
}
