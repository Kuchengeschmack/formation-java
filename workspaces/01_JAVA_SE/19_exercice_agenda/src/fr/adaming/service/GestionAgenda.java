package fr.adaming.service;

import java.util.ArrayList;

import fr.adaming.modele.Personne;

public abstract class GestionAgenda {

	private static ArrayList<Personne> liste;
	
	public static Personne ajouterPersonne(Personne p) {
		Personne q = new Personne(p.getNom(), p.getAdresse(), p.getNumTelephone());
		liste.add(q);
		return q;
	}
	
	
	public static Personne rechercherPersonne(String nom) {
		for(int i = 0; i < liste.size(); i++) {
			if(liste.get(i).getNom().equals(nom))
				return liste.get(i);
		}
		return null;
	}	
	
	public static Personne rechercherPersonne(int numTelephone) {
		for(int i = 0; i < liste.size(); i++) {
			if(liste.get(i).getNumTelephone() == numTelephone)
				return liste.get(i);
		}
		return null;
	}	
	
	public static void affichageComplet() {
		for(int i = 0; i < liste.size(); i++) {
			liste.get(i).toString();
		}
	}
	
	
}
