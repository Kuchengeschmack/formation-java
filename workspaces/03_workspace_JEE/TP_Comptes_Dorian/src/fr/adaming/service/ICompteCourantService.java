package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;

public interface ICompteCourantService {

	public List<CompteCourant> getAllCompte(Client clientIn);

	public int addCompte(Client clientIn, CompteCourant compteIn);

	public int updateCompte(Client clientIn, CompteCourant compteIn);

	public int deleteCompteById(Client clientIn, CompteCourant compteIn);

	public CompteCourant getCompteById(Client clientIn, CompteCourant compteIn);
	
	public int retirer(Client clientIn, CompteCourant compteIn, Double montant);
	
	public int deposer(Client clientIn, CompteCourant compteIn, Double montant);
	
	public int virer(Client clientDebiteur, Client clientCrediteur, CompteCourant compteDebiteur, CompteCourant compteCrediteur, Double montant);
}
