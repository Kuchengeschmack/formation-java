package fr.adaming.dao;

import fr.adaming.entites.Formateur;

public interface IFormateurDao {

	public Formateur isExist(Formateur fIn); // En entr�e : mail et mot de passe. En sortie : id, mail, mdp
}
