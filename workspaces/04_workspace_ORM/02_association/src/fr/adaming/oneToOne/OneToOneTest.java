package fr.adaming.oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToOneTest {

	public static void main(String[] args) {
		// 1: Cr�ation de l'entityManagerFactory (ligne)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_association");

		// 2: Cr�ation d'un entityManager � partir de emf (wagon)
		EntityManager em = emf.createEntityManager();

		// 3: Cr�ation d'une EntityTransaction (voyage)
		EntityTransaction tx = em.getTransaction();

		// 3.a: Commencer la transaction
		tx.begin();

		// Instancier les objets
		Personne p1 = new Personne("TOTO", "Titi");
		Personne p2 = new Personne("FOFO", "Fifi");
		Personne p3 = new Personne("RORO", "Riri");

		Voiture v1 = new Voiture("Renault", "Clio");
		Voiture v2 = new Voiture("Fiat", "500");

		// Lier les objets en Java
		p1.setVoiture(v1);
		v1.setProprietaire(p1);
		p2.setVoiture(v2);
		v2.setProprietaire(p2);

		// Rendre les objets Java persistents
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(v1);
		em.persist(v2);

		tx.commit();

		// Fermer les flux
		em.close();
		emf.close();

	}

}
