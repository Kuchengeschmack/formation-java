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

	public List<CompteEpargne> getAllCompte(Client clientIn) {
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

	@Override
	public int retirer(Client clientIn, CompteEpargne compteIn, Double montant) {

		compteIn.setClient(clientIn);
		clientIn.setCompteEpargne(compteIn);

		if (compteIn.getSolde() - montant >= 0) {
			compteIn.setSolde(compteIn.getSolde() - montant);
			return compteDao.updateCompte(clientIn, compteIn);
		} else {
			return 0;
		}

	}

	@Override
	public int deposer(Client clientIn, CompteEpargne compteIn, Double montant) {
		// On retire moins le montant comme ça ça tient en une ligne
		return retirer(clientIn, compteIn, -montant);
	}

	@Override
	public int virer(Client clientDebiteur, Client clientCrediteur, CompteEpargne compteDebiteur,
			CompteEpargne compteCrediteur, Double montant) {

		if (retirer(clientDebiteur, compteDebiteur, montant) != 0) {
			// Si le retrait du compte débiteur est réussi, déposer sur le compte créditeur
			if (deposer(clientCrediteur, compteCrediteur, montant) != 0) {
				// Si le dépôt est réussi, l'opération est réussie et on retourne 1
				return 1;
			} else {
				// Sinon, on rend l'argent au compte débiteur et on retourne 0 : échec
				deposer(clientDebiteur, compteDebiteur, montant);
				return 0;
			}
		} else {
			// Si le retrait n'a pas réussi, échec on renvoie 0
			return 0;
		}
	}

}
