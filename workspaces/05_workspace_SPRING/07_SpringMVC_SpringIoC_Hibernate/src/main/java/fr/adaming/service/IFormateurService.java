package fr.adaming.service;

import fr.adaming.entities.Formateur;

public interface IFormateurService {

	public Formateur getFormateurByMail(String mail);
}
