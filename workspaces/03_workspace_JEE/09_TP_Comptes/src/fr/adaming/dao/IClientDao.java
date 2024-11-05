package fr.adaming.dao;

import fr.adaming.entities.Client;

public interface IClientDao {

	public Client isExist(Client clientInt); // En entrée : mail et mot de passe. En sortie : id, mail, mdp

	public int ajouterClient(Client clientIn);
	
	public int modifierClient(Client clientIn);
}
