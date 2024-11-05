package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.CompteCourantDaoImpl;
import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;

public class CompteCourantServiceImpl implements ICompteCourantService {

	private CompteCourantDaoImpl compteDao;

	public CompteCourantServiceImpl() {
		// Transformation de l'association UML en Java
		compteDao = new CompteCourantDaoImpl();
	}
	
	public List<CompteCourant> getAllCompte(Client clientIn){
		return compteDao.getAllCompte(clientIn);
		}

	@Override
	public int addCompte(Client clientIn, CompteCourant compteIn) {

		if (clientIn.getCompteCourant() == null) {
			// Lier les objets en Java
			compteIn.setClient(clientIn);
			clientIn.setCompteCourant(compteIn);
			return compteDao.addCompte(clientIn, compteIn);
		} else {
			return 0;
		}
	}

	@Override
	public int updateCompte(Client clientIn, CompteCourant compteIn) {

		// Lier les objets en Java
		compteIn.setClient(clientIn);
		clientIn.setCompteCourant(compteIn);
		return compteDao.updateCompte(clientIn, compteIn);
	}

	@Override
	public int deleteCompteById(Client clientIn, CompteCourant compteIn) {

		// Vérifier que le client possède déjà un compte
		if (clientIn.getCompteCourant() != null) {
			// Lier les objets en Java
			compteIn.setClient(clientIn);
			clientIn.setCompteCourant(null);
			return compteDao.deleteCompteById(clientIn, compteIn);
		} else {
			return 0;
		}
	}

	@Override
	public CompteCourant getCompteById(Client clientIn, CompteCourant compteIn) {
		// Lier les objets en Java
		compteIn.setClient(clientIn);
		clientIn.setCompteCourant(compteIn);
		return compteDao.getCompteById(clientIn, compteIn);
	}
}
