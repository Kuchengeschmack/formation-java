package fr.adaming.modele;

import java.util.Arrays;

public class Etudiant {
	
	private String nom;
	private String prenom;
	private double[] notes;
	private double moyenne;
	private Diplome diplome;
	
	public Etudiant() {
		
	}
	
	public Etudiant(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;
		this.notes = new double[5];
		this.diplome = null;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double[] getNotes() {
		return notes;
	}

	public void setNotes(double[] notes) {
		this.notes = notes;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}



	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", notes=" + Arrays.toString(notes) + ", moyenne="
				+ moyenne + ", diplome=" + diplome + "]";
	}
	
	
}
