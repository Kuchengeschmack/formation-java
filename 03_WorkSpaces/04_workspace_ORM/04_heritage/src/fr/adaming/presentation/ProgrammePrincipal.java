package fr.adaming.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Ingenieur;
import fr.adaming.entities.Personne;
import fr.adaming.entities.Technicien;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Récupérer l'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_heritage");

		// Récupérer l'EntityManager
		EntityManager em = emf.createEntityManager();

		// Récupérer la transaction
		EntityTransaction tx = em.getTransaction();

		// Commencer une transaction
		tx.begin();

		// Instancier des objets
		//Personne p1 = new Personne("TOTO", "Titi");
		//Personne p2 = new Personne("FOFO", "Fifi");

		Ingenieur ing1 = new Ingenieur("RORO", "Riri", "Informatique");
		Ingenieur ing2 = new Ingenieur("YOYO", "Yiyi", "Physique");

		Technicien t1 = new Technicien("COCO", "Fifo", "Agent");
		Technicien t2 = new Technicien("DODO", "Jean", "Maintenance");

		// Rendre les objets persistants
		//em.persist(p1);
		//em.persist(p2);

		em.persist(ing1);
		em.persist(ing2);

		em.persist(t1);
		em.persist(t2);
		
		tx.commit();
		em.close();
		emf.close();

	}

}
