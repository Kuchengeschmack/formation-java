package fr.adaming.presentation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.adaming.entities.Employe;

public class JpqlTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// 1: Création de l'entityManagerFactory (ligne)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		// 2: Création d'un entityManager à partir de emf (wagon)
		EntityManager em = emf.createEntityManager();

//		//================================ Liste des employés
//		// Écrire l requête JPQL pour récupérer la liste
//		String reqListeJpql = "SELECT e FROM Employe AS e";
//
//		// Créer un objet de type Query afin d'exécuter la requête JPQL
//		Query queryListeJpql = em.createQuery(reqListeJpql); // Requête JPQL
//
//		List<Employe> ListeJpql = queryListeJpql.getResultList();
//
//		ListeJpql.forEach(System.out::println);
//		
//		//================================ Liste des noms des employés
//		String reqListeNomJpql = "SELECT e.nom FROM Employe AS e";
//		Query queryListeNomJpql = em.createQuery(reqListeNomJpql);
//		List<String> ListeNomJpql = queryListeNomJpql.getResultList();
//
//		ListeNomJpql.forEach(System.out::println);
//		
//		//================================ Retourne un employé par son nom et son prénom
//		String reqOne = "SELECT e FROM Employe AS e WHERE e.nom=:pNom AND e.prenom=:pPrenom";
//		// "SELECT e FROM Employe AS e WHERE e.nom=?1 AND e.prenom=?2"
//		
//		// Récupérer l'objet Query
//		Query queryOne = em.createQuery(reqOne);
//		
//		// Passage des parramètres à la requête JPQL
//		queryOne.setParameter("pNom", "BOULMERDJ");
//		queryOne.setParameter("pPrenom", "Probleme");
//		
//		// Envoyer la requête
//		Employe empJpql = (Employe) queryOne.getSingleResult();
//
//		System.out.println(empJpql);
//		
//		//============================ Liste des employés avec les requêtes nommées
//		Query queryListeNamed = em.createNamedQuery("ListeNamed");
//		
//		// Envoyer la requête
//		List<Employe> listeNamedQuery = queryListeNamed.getResultList();
//		listeNamedQuery.forEach(System.out::println);
//		
//		//============================ Rechercher un employé avec les requêtes nommées
//		Query queryOneNamed = em.createNamedQuery("oneNamed");
//		
//		// Passage des paramètres
//		queryOneNamed.setParameter("pNom", "BOULMERDJ");
//		queryOneNamed.setParameter("pPrenom", "Probleme");
//		
//		// Envoyer la requête
//		Employe empNamed = (Employe) queryOneNamed.getSingleResult();
//		System.out.println(empNamed);
		
		//============================ Liste des employés avec SQL
		// Ecrire la requête SQL
		String reqListeSql = "SELECT * FROM Employes";
		
		// Récupérer l'objet query afin d'envoyer
		Query queryListeSql = em.createNativeQuery(reqListeSql,  Employe.class);
		
		List<Employe> listeSql = queryListeSql.getResultList();

		listeSql.forEach(System.out::println);
		
		// 4- Fermer les flux
		em.close();
		emf.close();

	}

}
