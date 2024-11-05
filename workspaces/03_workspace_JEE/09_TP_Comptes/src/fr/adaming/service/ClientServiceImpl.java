package fr.adaming.service;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

public class ClientServiceImpl implements IClientService {

	// transformation d'association UML en Java
	private IClientDao clientDao = new ClientDaoImpl();

	@Override
	public Client isExist(Client clientIn) {

		// Appel de la m�thode service
		return clientDao.isExist(clientIn);
	}

	@Override
	public int ajouterClient(Client clientIn) {

		/**
		 * Si le courriel client existe d�j� dans la base de donn�es Ne pas cr�er de
		 * compte
		 */

		return clientDao.ajouterClient(clientIn);
	}

	@Override
	public int modifierClient(Client clientIn) {
		return clientDao.modifierClient(clientIn);
	}

}
