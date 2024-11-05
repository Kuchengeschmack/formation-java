package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;

public interface ICompteEpargneService {

	public List<CompteEpargne> getAllCompte(Client clientIn);

	public int addCompte(Client clientIn, CompteEpargne compteIn);

	public int updateCompte(Client clientIn, CompteEpargne compteIn);

	public int deleteCompteById(Client clientIn, CompteEpargne compteIn);

	public CompteEpargne getCompteById(Client clientIn, CompteEpargne compteCourantIn);
}
