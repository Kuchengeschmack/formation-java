package fr.adaming.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.oneToMany.Bibliotheque;
import fr.adaming.oneToMany.Livre;

public class ManyToManyTest {

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
		Matiere m1 = new Matiere("JAVA");
		Matiere m2 = new Matiere("C#");
		
		Etudiant e1 = new Etudiant("TOTO");
		Etudiant e2 = new Etudiant("RORO");
		Etudiant e3 = new Etudiant("FOFO");
		Etudiant e4 = new Etudiant("YOYO");
		
		List<Etudiant> liste1 = new ArrayList<Etudiant>();
		
		liste1.add(e1);
		liste1.add(e2);
		
		List<Etudiant> liste2 = new ArrayList<Etudiant>();
		
		liste2.add(e3);
		liste2.add(e4);
		
		// Lier les objets en Java
		m1.setEtudiants(liste1);
		m2.setEtudiants(liste2);
		
		// Rendre les objets persistants
		em.persist(m1);
		em.persist(m2);
		
		// Soumettre la tx
		tx.commit();
		
		em.close();
		emf.close();

	}

}
