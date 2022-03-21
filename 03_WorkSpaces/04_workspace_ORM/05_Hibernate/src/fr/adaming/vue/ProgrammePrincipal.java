package fr.adaming.vue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import fr.adaming.entities.Employe;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Ajouter les objets dans la bd
		// createTest();

		// Récupérer un objet par son id
		// getTest();

		// Modifier un objet
		//getTest();
		
		// Supprimer un objet
		deleteTest();

	}

	public static void createTest() {

		// 1- Récupérer la SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// 2- Récupérer la session hibernate
		Session s = sf.openSession();

		// 3- Récupérer et commencer la transaction
		Transaction tx = s.beginTransaction();

		// Instancier les objets Java
		Employe e1 = new Employe("TOTO", "Titi", 200.25);
		Employe e2 = new Employe("FOFO", "Fifi", 275.25);
		Employe e3 = new Employe("RORO", "Riri", 300.25);

		// Rendre les objets persistants
		s.save(e1);
		s.save(e2);
		s.save(e3);

		tx.commit();

		// Fermer les flux
		s.close();
		sf.close();
	}

	public static void getTest() {
		// 1- Récupérer la SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// 2- Récupérer la session hibernate
		Session s = sf.openSession();

		// Récupérer un objet par son id
		Employe e1 = (Employe) s.get(Employe.class, 1);

		System.out.println(e1);

		// Fermer les flux
		s.close();
		sf.close();

	}

	public static void updateTest() {
		// 1- Récupérer la SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// 2- Récupérer la session hibernate
		Session s = sf.openSession();

		// 3- Récupérer et commencer la transaction
		Transaction tx = s.beginTransaction();

		// Récupérer un objet par son id
		Employe eModif = (Employe) s.get(Employe.class, 2);

		// Modifier l'objet en java
		eModif.setNom("BOULMERDJ");
		eModif.setPrenom("Nomane");
		eModif.setSalaire(100.);

		// Update l'objet dans le contexte de session hibernate
		s.update(eModif);

		// Commit tx
		tx.commit();

		// Fermer les flux
		s.close();
		sf.close();
	}

	public static void deleteTest() {
		// 1- Récupérer la SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// 2- Récupérer la session hibernate
		Session s = sf.openSession();

		// 3- Récupérer et commencer la transaction
		Transaction tx = s.beginTransaction();
		
		// Récupérer l'objet par son id
		Employe eDel = (Employe) s.get(Employe.class, 3);
		
		// Supprimer l'objet du contexte de la session hibernate
		s.delete(eDel);
		
		// Commit tx
		tx.commit();
		
		// Fermer les flux
		s.close();
		sf.close();
	}
}
