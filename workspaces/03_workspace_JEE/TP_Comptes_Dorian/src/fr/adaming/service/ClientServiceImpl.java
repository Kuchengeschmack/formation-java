package fr.adaming.service;

import java.util.List;

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
	
	public List<Client> getAllClient(){
		return clientDao.getAllClient();
	}

	@Override
	public int ajouterClient(Client clientIn) {

		/**
		 * Si le compte client existe d�j� dans la base de donn�es Ne pas cr�er de
		 * compte
		 */

		return clientDao.ajouterClient(clientIn);
	}

	@Override
	public int modifierClient(Client clientIn) {
		return clientDao.modifierClient(clientIn);
	}

	public Client getClientById(Client client) {
		return clientDao.getClientById(client);
	}
	
	public int deleteClientById(Client client) {
		return clientDao.deleteClientById(client);
	}

}
