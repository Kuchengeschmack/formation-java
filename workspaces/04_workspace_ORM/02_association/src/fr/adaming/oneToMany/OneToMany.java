package fr.adaming.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToMany {

	public static void main(String[] args) {
		// Création d'une entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_association");

		// Création d'un entityManager
		EntityManager em = emf.createEntityManager();

		// Récupérer la transaction
		EntityTransaction tx = em.getTransaction();

		// Commencer une transaction
		tx.begin();

		// Instancier les objets
		Livre l1 = new Livre("JAVA", "TOTO");
		Livre l2 = new Livre("C#", "RORO");
		Livre l3 = new Livre("PHP", "FOFO");
		Livre l4 = new Livre("Python", "YOYO");

		Bibliotheque b1 = new Bibliotheque("Art", "Paris");
		Bibliotheque b2 = new Bibliotheque("Metier", "Bordeaux");

		List<Livre> liste1 = new ArrayList<Livre>();
		liste1.add(l1);
		liste1.add(l2);

		List<Livre> liste2 = new ArrayList<Livre>();
		liste2.add(l3);
		liste2.add(l4);

		// Lier les objets en Java
		b1.setLivres(liste1);
		b2.setLivres(liste2);

		l1.setBibliotheque(b1);
		l2.setBibliotheque(b1);

		l3.setBibliotheque(b2);
		l4.setBibliotheque(b2);

		// Rendre les objets persistants
		em.persist(b1);
		em.persist(b2);

		// Pas besoin de faire persister les livres dans le contexte de persistance
//		em.persist(l1);
//		em.persist(l2);
//		em.persist(l3);
//		em.persist(l4);

		// Soummetre le transaction
		tx.commit();

		// Fermer les flux
		em.close();
		emf.close();

	}
}
