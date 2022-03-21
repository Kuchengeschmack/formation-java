package fr.adaming.presentation;

import fr.adaming.modele.Etudiant;
import fr.adaming.modele.GestionGroupe;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double listeNotes[] = new double[] {12,9,15,10,2};
		Etudiant e1 = new Etudiant("Dupont", "Jean-Michel");
		
		
		GestionGroupe.inscrireEtudiant(e1);
		GestionGroupe.inscrireNotes(e1, listeNotes);
		GestionGroupe.calculerMoyennes();
		GestionGroupe.attribuerDiplomes();
		
		System.out.println(e1.toString());
		
		
	}

}
