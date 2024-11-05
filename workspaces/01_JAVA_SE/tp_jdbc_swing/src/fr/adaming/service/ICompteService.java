package fr.adaming.service;

import java.util.List;

import fr.adaming.modele.Compte;

public interface ICompteService {

	public int supprimerCompteService(int idC);

	public int modifierCompteService(Compte c);

	public List<Compte> getAllCompteService();

	public Compte chercherIdCompteService(int idC);

	public Compte chercherIdClientCompteService(int idCl);

	public int attribuerCompteService(Compte c);

	public int retirerCompteService(int idC, double montant);

	public int deposerCompteService(int idC, double montant);

	public boolean virerCompteService(int idDebit, int idCredit, double montant);
}
