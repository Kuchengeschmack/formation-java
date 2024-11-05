package fr.adaming.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.adaming.entities.Employe;

public class FindTest {

	public static void main(String[] args) {
		// 1- Cr�ation d'un objet de type EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		
		// 2- Cr�ation d'un objet de type EntityManager
		EntityManager em = emf.createEntityManager();
		
		// 2bis- Pas besoin de transaction car on acc�de � la BD en lecture
		// 3- Chercher un employ� avec sa clef primaire
		Employe emp = em.find(Employe.class, 1);
		
		System.out.println(emp);
		
		// 4- Fermer les flux
		em.close();
		emf.close();
	}
}
