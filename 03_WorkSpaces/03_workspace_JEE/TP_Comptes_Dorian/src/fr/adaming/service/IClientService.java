package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;

public interface IClientService {

	public Client isExist(Client clientIn);

	public List<Client> getAllClient();

	public int ajouterClient(Client clientIn);

	public int modifierClient(Client clientIn);

	public Client getClientById(Client client);
	
	public int deleteClientById(Client client);
}
