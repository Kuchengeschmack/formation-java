package fr.adaming.vue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.modele.Adresse;
import fr.adaming.modele.Employe;
import fr.adaming.modele.Entreprise;
import fr.adaming.modele.Projet;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Association 1 - N
		// exerciceUn();

		// Association 1 - 1
		// exerciceDeux();

		// Association N - M
		// exerciceTrois();

		// Association 1 - N : classe Equipe
		exerciceQuatre();
	}

	// OK
	public static void exerciceUn() {
		// Cr�ation d'une entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_Exercices");

		// Cr�ation d'un entityManager
		EntityManager em = emf.createEntityManager();

		// R�cup�rer la transaction
		EntityTransaction tx = em.getTransaction();

		// Commencer une transaction
		tx.begin();

		// Instancier les objets
		Employe emp1 = new Employe("R�ale--Caron", "Dorian", 23);
		Employe emp2 = new Employe("R�ale--Caron", "�va", 21);

		Entreprise ent1 = new Entreprise("Dorian Inc.");

		List<Employe> liste1 = new ArrayList<Employe>();
		liste1.add(emp1);
		liste1.add(emp2);

		// Lier les objets en Java
		emp1.setEntreprise(ent1);
		emp2.setEntreprise(ent1);

		ent1.setEmployes(liste1);

		// Rendre les objets persistants
		em.persist(ent1); // On profite de la propri�t� Cascade

		// Soummetre le transaction
		tx.commit();

		// R�cup�rer l'entreprise
		Entreprise ent1Bis = em.find(Entreprise.class, 1);

		System.out.println(ent1Bis);

		System.out.println("\n---------------------------------------------------------");

		for (Employe emp : ent1Bis.getEmployes()) {
			System.out.println(emp);
		}

		tx.begin();

		// Cr�ation d'un nouvel employ�
		Employe emp3 = new Employe("Boulmerdj", "Nomane", 30);
		emp3.setEntreprise(ent1);
		ent1Bis.getEmployes().add(emp3);

		em.persist(ent1Bis);

		tx.commit();

		ent1Bis = em.find(Entreprise.class, 1);

		System.out.println(ent1Bis);

		System.out.println("\n---------------------------------------------------------");

		for (Employe emp : ent1Bis.getEmployes()) {
			System.out.println(emp);
		}

		// Fermer les flux
		em.close();
		emf.close();
	}

	// OK
	public static void exerciceDeux() {

		// Cr�ation d'une entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_Exercices");

		// Cr�ation d'un entityManager
		EntityManager em = emf.createEntityManager();

		// R�cup�rer la transaction
		EntityTransaction tx = em.getTransaction();

		// Commencer une transaction
		tx.begin();

		// Instancier les objets
		Employe emp1 = new Employe("R�ale--Caron", "Dorian", 23);
		Adresse adr1 = new Adresse("5 Place de Lattre de Tassigny", "Montmorency", 95160);

		emp1.setAdresse(adr1);

		em.persist(emp1);

		tx.commit();

		Employe empFind = em.find(Employe.class, 1);

		System.out.println("\n------- L'employ� et son adresse");
		System.out.println(empFind.toString());
		System.out.println(empFind.getAdresse().toString());

		em.close();
		emf.close();
	}

	// OK
	public static void exerciceTrois() {
		// Cr�ation d'une entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_Exercices");

		// Cr�ation d'un entityManager
		EntityManager em = emf.createEntityManager();

		// R�cup�rer la transaction
		EntityTransaction tx = em.getTransaction();

		// Commencer une transaction
		tx.begin();

		// Instancier les objets
		Employe emp1 = new Employe("R�ale--Caron", "Dorian", 23);
		Employe emp2 = new Employe("R�ale--Caron", "�va", 21);
		Employe emp3 = new Employe("Caron", "Marie-C�cile", 63);
		Employe emp4 = new Employe("R�ale", "Thierry", 59);

		Projet proj1 = new Projet("Projet1");
		Projet proj2 = new Projet("Projet2");

		List<Projet> projets1 = new ArrayList<Projet>();
		List<Projet> projets2 = new ArrayList<Projet>();
		List<Projet> projets3 = new ArrayList<Projet>();

		projets1.add(proj1);
		projets1.add(proj2);

		projets2.add(proj2);

		projets3.add(proj1);

		emp1.setProjets(projets1);
		emp2.setProjets(projets1);
		emp3.setProjets(projets2);
		emp4.setProjets(projets3);

		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);

		tx.commit();

		em.close();
		emf.close();
	}

	public static void exerciceQuatre() {

		
	}
}
