package fr.adaming.dao;

import java.util.List;

import fr.adaming.modele.Client;


public interface IClientDao {

	public int ajouterClientDao(Client c);
	
	public int supprimerClientDao(int idC);
	
	public int modifierClientDao(Client c);
	
	public List<Client> getAllClientDao();
	
	public Client chercherClientDao(int Idc);
	
}
