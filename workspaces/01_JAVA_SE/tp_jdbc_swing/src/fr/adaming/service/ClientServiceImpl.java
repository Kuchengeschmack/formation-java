package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.modele.Client;

public class ClientServiceImpl implements IClientService {

	private IClientDao cDao = new ClientDaoImpl();

	@Override
	public int ajouterClientService(Client c) {
		int verif = cDao.ajouterClientDao(c);
		return verif;
	}

	@Override
	public int supprimerClientService(int idC) {
		int verif = cDao.supprimerClientDao(idC);
		return verif;
	}

	@Override
	public int modifierClientService(Client c) {
		int verif = cDao.modifierClientDao(c);
		return verif;
	}

	@Override
	public List<Client> getAllClientService() {
		List<Client> liste = cDao.getAllClientDao();
		return liste;
	}

	@Override
	public Client chercherClientService(int idC) {
		Client c = cDao.chercherClientDao(idC);
		return c;
	}

}
