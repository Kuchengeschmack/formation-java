package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;

public interface ICompteCourantDao {
	public List<CompteCourant> getAllCompte(Client fIn);

	public int addCompte(Client client, CompteCourant compte);

	public int updateCompte(Client client, CompteCourant compte);

	public int deleteCompteById(Client client, CompteCourant compte);

	public CompteCourant getCompteById(Client client, CompteCourant cIn);
}
