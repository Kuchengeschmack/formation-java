package fr.adaming.modele;

import java.util.ArrayList;

public abstract class GestionGroupe {

	private static ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>(); // Tableau dynamique des étudiants
	
	public static void inscrireEtudiant(Etudiant etudiant) {
		listeEtudiant.add(etudiant);
	}
	
	public static void inscrireNotes(Etudiant etudiant, double[] notes) {
		etudiant.setNotes(notes);
	}
	
	public static void calculerMoyennes() {
		
		for(Etudiant e : listeEtudiant) {
			int moy = 0;
			for(double n : e.getNotes()) {
				moy += n;
			}
			moy /= 5;
			e.setMoyenne(moy);
		}
	}
	
	public static void attribuerDiplomes() {
		for(Etudiant e : listeEtudiant) {
			if(e.getMoyenne() >= 10) {
				e.setDiplome(new Diplome());
			} else {
				e.setDiplome(null); // Pas de dipôme
			}
		}
	}
	
}
