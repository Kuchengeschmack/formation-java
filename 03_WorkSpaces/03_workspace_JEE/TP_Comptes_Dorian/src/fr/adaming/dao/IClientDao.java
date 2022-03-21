package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;

public interface IClientDao {

	public Client isExist(Client clientInt); // En entrée : mail et mot de passe. En sortie : id, mail, mdp
	
	public List<Client> getAllClient();

	public int ajouterClient(Client clientIn);
	
	public int modifierClient(Client clientIn);
	
	public Client getClientById(Client client);
	
	public int deleteClientById(Client client);
}
