package com.inti;

public class Main {

	public static void main(String[] args) {
		
		// Instanciation via constructeur classique et utilisation des setters
		
		Etudiant e1 = new Etudiant();
		Professeur p1 = new Professeur();
		
		e1.setIdentifiant(1);
		e1.setNom("Dupont");
		e1.setPrenom("Corinne");
		e1.setNumSecu(351531);
		e1.setAnneeEtude(1);
		e1.setFraisInscription();
		
		p1.setIdentifiant(3);
		p1.setNom("Bonbeurre");
		p1.setPrenom("Jean");
		p1.setNumSecu(355454);
		p1.setAnciennete(5);
		p1.setSalaire();
		
		e1.afficherInfos();
		p1.afficherInfos();

		// Instanciation via les constructeurs surchargés
		
		Etudiant e2 = new Etudiant(2, "Lefevbre", "Éric", 213545313, 3);
		Professeur p2 = new Professeur(4, "Martin", "Eugène", 455466, 2);
		
		e2.afficherInfos();
		p2.afficherInfos();

		// Comparaison des étudiants pour afficher celui qui paie le plus de frais d'inscription
		
		System.out.println("\n"); // Un saut de ligne
		
		if(e1.getFraisInscription() > e2.getFraisInscription())
		{
			System.out.println("L\'etudiant " + e1.getIdentifiant() + " paie le plus de frais d\'inscription.");
			e1.afficherInfos();
		}
		else
		{
			System.out.println("L\'etudiant " + e2.getIdentifiant() + " paie le plus de frais d\'inscription.");
			e2.afficherInfos();
		}
		
		// Comparaison des professeurs pour les afficher par ordre alphabétique de nom
		
		System.out.println("\n");	// Saut de ligne
		
		if((int) p1.getNom().charAt(0) < (int) p2.getNom().charAt(0))
		{
			p1.afficherInfos();
			p2.afficherInfos();
		}
		else
		{
			p2.afficherInfos();
			p1.afficherInfos();
		}
		
		System.out.println("\n");	// Saut de ligne
		
		// Verification que modifier anciennete et anneeEtude entraine la modification de salaire et fraisInscription
		
		p1.setAnciennete(6);
		e1.setAnneeEtude(5);
		
		e1.afficherInfos();
		p1.afficherInfos();
		
	}

}
