package fr.adaming.service;

import java.util.List;

import fr.adaming.modele.Client;

public interface IClientService {

	public int ajouterClientService(Client c);

	public int supprimerClientService(int idC);

	public int modifierClientService(Client c);

	public List<Client> getAllClientService();

	public Client chercherClientService(int idC);
}
