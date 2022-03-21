package fr.adaming.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Employe;

public class RemoveTest {

	public static void main(String[] args) {
		// 1: Création de l'entityManagerFactory (ligne)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		// 2: Création d'un entityManager à partir de emf (wagon)
		EntityManager em = emf.createEntityManager();

		// 3: Création d'une EntityTransaction (voyage)
		EntityTransaction tx = em.getTransaction();

		// 3.a: Commencer la transaction
		tx.begin();

		// Chercher l'objet à supprimer de la BD en passant par le contexte de
		// persistance
		Employe empDel = em.find(Employe.class, 2);

		// Supprimer l'objet dans le contexte de persistance
		em.remove(empDel);

		// Commit la transaction
		tx.commit();

		// Fermer les flux
		em.close();
		emf.close();

	}

}
