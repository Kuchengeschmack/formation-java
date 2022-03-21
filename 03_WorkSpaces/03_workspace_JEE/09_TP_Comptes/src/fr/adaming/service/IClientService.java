package fr.adaming.service;

import fr.adaming.entities.Client;

public interface IClientService {

	public Client isExist(Client clientIn);
	
	public int ajouterClient(Client clientIn);
	
	public int modifierClient(Client clientIn);
}
