package fr.adaming.dao;

import fr.adaming.entities.Formateur;

public interface IFormateurDao {

	public Formateur getFormateurByMail(String mail);

}
