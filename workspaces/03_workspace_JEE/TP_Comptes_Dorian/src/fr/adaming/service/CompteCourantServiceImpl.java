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

	public List<CompteCourant> getAllCompte(Client clientIn) {
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

		// V�rifier que le client poss�de d�j� un compte
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

	@Override
	public int retirer(Client clientIn, CompteCourant compteIn, Double montant) {

		compteIn.setClient(clientIn);
		clientIn.setCompteCourant(compteIn);

		if (compteIn.getSolde() - montant >= CompteCourant.decouvertAutorise) {
			compteIn.setSolde(compteIn.getSolde() - montant);
			return compteDao.updateCompte(clientIn, compteIn);
		} else {
			return 0;
		}

	}

	@Override
	public int deposer(Client clientIn, CompteCourant compteIn, Double montant) {
		// On retire moins le montant comme �a �a tient en une ligne
		return retirer(clientIn, compteIn, -montant);
	}
	
	@Override
	public int virer(Client clientDebiteur, Client clientCrediteur, CompteCourant compteDebiteur, CompteCourant compteCrediteur, Double montant) {

		if (retirer(clientDebiteur, compteDebiteur, montant) != 0) {
			// Si le retrait du compte d�biteur est r�ussi, d�poser sur le compte cr�diteur
			if (deposer(clientCrediteur, compteCrediteur, montant) != 0) {
				// Si le d�p�t est r�ussi, l'op�ration est r�ussie et on retourne 1
				return 1;
			} else {
				// Sinon, on rend l'argent au compte d�biteur et on retourne 0 : �chec
				deposer(clientDebiteur, compteDebiteur, montant);
				return 0;
			}
		} else {
			// Si le retrait n'a pas r�ussi, �chec on renvoie 0
			return 0;
		}
	}

}
