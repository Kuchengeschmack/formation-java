package fr.adaming.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Employe;

public class MergeTest {

	public static void main(String[] args) {
		// 1- Création d'un EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		
		// 2- Création d'un EntityManager
		EntityManager em = emf.createEntityManager();
		
		// 3- Récupérer une Transaction
		EntityTransaction tx = em.getTransaction();
		
		// 4- Commencer une transaction
		tx.begin();
		
		// Chercher l'employé à modifier par son id (pour l'ajouter dans le contexte de persistance)
		Employe empModif = em.find(Employe.class, 1);
		
		// Modifier l'objet en Java
		empModif.setNom("BOULMERDJ");
		empModif.setPrenom("Probleme");
		
		// Modifier l'objet dans le contexte de persistance
		em.merge(empModif);
		
		// Commit la transaction (apporter les modifications du contexte de persistance dans la BD)
		tx.commit();
		
		// Fermer les flux
		em.close();
		emf.close();

	}

}
