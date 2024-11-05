package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;

public interface ICompteEpargneDao {
	public List<CompteEpargne> getAllCompte(Client fIn);

	public int addCompte(Client client, CompteEpargne compte);

	public int updateCompte(Client client, CompteEpargne compte);

	public int deleteCompteById(Client client, CompteEpargne compte);

	public CompteEpargne getCompteById(Client client, CompteEpargne cIn);
}
