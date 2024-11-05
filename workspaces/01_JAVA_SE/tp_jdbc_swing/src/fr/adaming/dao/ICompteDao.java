package fr.adaming.dao;

import java.util.List;

import fr.adaming.modele.Compte;

public interface ICompteDao {

	public int supprimerCompteDao(int idC);
	
	public int modifierCompteDao(Compte c);
	
	public List<Compte> getAllCompteDao();
	
	public Compte chercherIdCompteDao(int idC);
	
	public Compte chercherIdClientCompteDao(int idCl);
	
	public int attribuerCompteDao(Compte c);
	
	public int retirerCompteDao(int idC, double montant);
	
	public int deposerCompteDao(int idC, double montant);
	
	public boolean virerCompteDao(int idDebit, int idCredit, double montant);
	
}
