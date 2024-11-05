package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.CompteEpargneDaoImpl;
import fr.adaming.dao.ICompteEpargneDao;
import fr.adaming.modele.Compte;
import fr.adaming.modele.CompteCourant;

public class CompteEpargneServiceImpl implements ICompteEpargneService {

	private ICompteEpargneDao cDao = new CompteEpargneDaoImpl();

	@Override
	public int supprimerCompteService(int idC) {
		int verif = cDao.supprimerCompteDao(idC);
		return verif;
	}

	@Override
	public int modifierCompteService(Compte c) {
		int verif = cDao.modifierCompteDao(c);
		return verif;
	}

	@Override
	public List<Compte> getAllCompteService() {
		List<Compte> liste = cDao.getAllCompteDao();
		return liste;
	}

	@Override
	public Compte chercherIdCompteService(int idC) {
		Compte c = cDao.chercherIdCompteDao(idC);
		return c;
	}

	@Override
	public Compte chercherIdClientCompteService(int idCl) {
		Compte c = cDao.chercherIdClientCompteDao(idCl);
		return c;
	}

	@Override
	public int attribuerCompteService(Compte c) {
		int verif = cDao.attribuerCompteDao(c);
		return verif;
	}

	@Override
	public int retirerCompteService(int idC, double montant) {
		// recherche du compte en question
		Compte c = chercherIdCompteService(idC);
		int verif;

		if (c.getSolde() - montant >= 0) {
			verif = cDao.retirerCompteDao(idC, montant);
			return verif;
		} else {
			return 0;
		}
	}

	@Override
	public int deposerCompteService(int idC, double montant) {
		int verif = cDao.deposerCompteDao(idC, montant);
		return verif;
	}

	@Override
	public boolean virerCompteService(int idDebit, int idCredit, double montant) {
		boolean verif = cDao.virerCompteDao(idDebit, idCredit, montant);
		return verif;
	}
}
