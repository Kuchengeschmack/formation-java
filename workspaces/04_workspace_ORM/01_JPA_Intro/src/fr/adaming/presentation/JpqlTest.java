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

		// 1: Cr�ation de l'entityManagerFactory (ligne)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		// 2: Cr�ation d'un entityManager � partir de emf (wagon)
		EntityManager em = emf.createEntityManager();

//		//================================ Liste des employ�s
//		// �crire l requ�te JPQL pour r�cup�rer la liste
//		String reqListeJpql = "SELECT e FROM Employe AS e";
//
//		// Cr�er un objet de type Query afin d'ex�cuter la requ�te JPQL
//		Query queryListeJpql = em.createQuery(reqListeJpql); // Requ�te JPQL
//
//		List<Employe> ListeJpql = queryListeJpql.getResultList();
//
//		ListeJpql.forEach(System.out::println);
//		
//		//================================ Liste des noms des employ�s
//		String reqListeNomJpql = "SELECT e.nom FROM Employe AS e";
//		Query queryListeNomJpql = em.createQuery(reqListeNomJpql);
//		List<String> ListeNomJpql = queryListeNomJpql.getResultList();
//
//		ListeNomJpql.forEach(System.out::println);
//		
//		//================================ Retourne un employ� par son nom et son pr�nom
//		String reqOne = "SELECT e FROM Employe AS e WHERE e.nom=:pNom AND e.prenom=:pPrenom";
//		// "SELECT e FROM Employe AS e WHERE e.nom=?1 AND e.prenom=?2"
//		
//		// R�cup�rer l'objet Query
//		Query queryOne = em.createQuery(reqOne);
//		
//		// Passage des parram�tres � la requ�te JPQL
//		queryOne.setParameter("pNom", "BOULMERDJ");
//		queryOne.setParameter("pPrenom", "Probleme");
//		
//		// Envoyer la requ�te
//		Employe empJpql = (Employe) queryOne.getSingleResult();
//
//		System.out.println(empJpql);
//		
//		//============================ Liste des employ�s avec les requ�tes nomm�es
//		Query queryListeNamed = em.createNamedQuery("ListeNamed");
//		
//		// Envoyer la requ�te
//		List<Employe> listeNamedQuery = queryListeNamed.getResultList();
//		listeNamedQuery.forEach(System.out::println);
//		
//		//============================ Rechercher un employ� avec les requ�tes nomm�es
//		Query queryOneNamed = em.createNamedQuery("oneNamed");
//		
//		// Passage des param�tres
//		queryOneNamed.setParameter("pNom", "BOULMERDJ");
//		queryOneNamed.setParameter("pPrenom", "Probleme");
//		
//		// Envoyer la requ�te
//		Employe empNamed = (Employe) queryOneNamed.getSingleResult();
//		System.out.println(empNamed);
		
		//============================ Liste des employ�s avec SQL
		// Ecrire la requ�te SQL
		String reqListeSql = "SELECT * FROM Employes";
		
		// R�cup�rer l'objet query afin d'envoyer
		Query queryListeSql = em.createNativeQuery(reqListeSql,  Employe.class);
		
		List<Employe> listeSql = queryListeSql.getResultList();

		listeSql.forEach(System.out::println);
		
		// 4- Fermer les flux
		em.close();
		emf.close();

	}

}
