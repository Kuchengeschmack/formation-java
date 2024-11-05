package fr.adaming.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Employe;

public class CreateTest {

	public static void main(String[] args) {
		// 1: Cr�ation de l'entityManagerFactory (ligne)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		// 2: Cr�ation d'un entityManager � partir de emf (wagon)
		EntityManager em = emf.createEntityManager();

		// 3: Cr�ation d'une EntityTransaction (voyage)
		EntityTransaction tx = em.getTransaction();

		// 3.a: Commencer la transaction
		tx.begin();

		// Cr�er une liste d'employ�s

		// Instancier les employ�s
		Employe em1 = new Employe("TOTO", "Titi", 2000.);
		Employe em2 = new Employe("FOFO", "Fifi", 2500.);
		Employe em3 = new Employe("RORO", "Riri", 2450.);

		Employe em4 = new Employe("D'Estaing", "Giscard", 9999.);

		// 4: Rendre les objets persistants (les liers au contexte de persistance de
		// l'entityManager)
		em.persist(em1);
		em.persist(em2);
		em.persist(em3);

		// On teste la m�thode contains pour savoir si un objet Java poss�de son correspondant dans la BDD
		boolean verif = em.contains(em1);
		boolean verif2 = em.contains(em4);
		System.out.println(em1 + " est-il dans la BDD ? R�ponse : " + verif);
		System.out.println(em4 + " est-il dans la BDD ? R�ponse : " + verif2); // renvoie false car on ne l'a pas fait
																				// persister

		// On teste la m�thode detach pour supprimer une ligne de la BDD
		em.detach(em3);
		boolean verif3 = em.contains(em3);
		System.out.println(em3 + " est-il dans la BDD ? R�ponse : " + verif3);
		
		// On test la m�thode find pour r�cup�rer un Employe par son id
		Employe emx = em.find(Employe.class, 1);
		System.out.println("L'employ� d'id 1 est " + emx);
		
		
		
		
		// 5: Commit la transaction (terminer le voyage)
		tx.commit();

		// 6: Fermer les flux
		em.close();
		emf.close();

	}

}
