package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.CompteEpargneDaoImpl;
import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;

public class CompteEpargneServiceImpl implements ICompteEpargneService {

	private CompteEpargneDaoImpl compteDao;

	public CompteEpargneServiceImpl() {
		// Transformation de l'association UML en Java
		compteDao = new CompteEpargneDaoImpl();
	}
	
	public List<CompteEpargne> getAllCompte(Client clientIn){
		return compteDao.getAllCompte(clientIn);
		}

	@Override
	public int addCompte(Client clientIn, CompteEpargne compteIn) {

		if (clientIn.getCompteEpargne() == null) {
			// Lier les objets en Java
			compteIn.setClient(clientIn);
			clientIn.setCompteEpargne(compteIn);
			return compteDao.addCompte(clientIn, compteIn);
		} else {
			return 0;
		}
	}

	@Override
	public int updateCompte(Client clientIn, CompteEpargne compteIn) {

		// Lier les objets en Java
		compteIn.setClient(clientIn);
		clientIn.setCompteEpargne(compteIn);
		return compteDao.updateCompte(clientIn, compteIn);
	}

	@Override
	public int deleteCompteById(Client clientIn, CompteEpargne compteIn) {

		// Vérifier que le client possède déjà un compte
		if (clientIn.getCompteEpargne() != null) {
			// Lier les objets en Java
			compteIn.setClient(clientIn);
			clientIn.setCompteEpargne(null);
			return compteDao.deleteCompteById(clientIn, compteIn);
		} else {
			return 0;
		}
	}

	@Override
	public CompteEpargne getCompteById(Client clientIn, CompteEpargne compteIn) {
		// Lier les objets en Java
		compteIn.setClient(clientIn);
		clientIn.setCompteEpargne(compteIn);
		return compteDao.getCompteById(clientIn, compteIn);
	}

}
