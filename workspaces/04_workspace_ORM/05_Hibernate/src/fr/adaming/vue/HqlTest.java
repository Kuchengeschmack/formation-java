package fr.adaming.vue;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fr.adaming.entities.Employe;

public class HqlTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Récupérer la SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// Récupérer la session
		Session s = sf.openSession();

		// La liste des employés avec HQL
		// Écrire la requête HQL
		String reqListeHql = "FROM Employe as e";

		// Récupérer l'objet Query afin d'executer la requête HQL
		Query queryListeHql = s.createQuery(reqListeHql);

		System.out.println("------------------ liste avec HQL");
		// Exécuter la requête HQL et récupérer la liste
		List<Employe> listeHql = queryListeHql.list();

		listeHql.forEach(System.out::println);

		// ================ La liste des noms avec HQL
		// Écrire la requête HQL
		String reqNoms = "SELECT e.nom FROM Employe e";
		
		// Récupérer l'objet Query afin d'executer la requête SQL
		Query queryNomsHql = s.createQuery(reqNoms);
		
		System.out.println("\n----------- liste des noms avec HQL");
		// Exécuter la requête HQL et récupérer la liste
		List<String> listeNomsHql = queryNomsHql.list();
		
		listeNomsHql.forEach(System.out::println);

		// =============== Un seul employé avec HQL
		// Écrire la requête HQL
		String reqOne = "FROM Employe e WHERE e.nom=:pNom AND e.prenom=:pPrenom";
		
		// Récupérer l'objet Query afin d'exécuter la requête HQL
		Query queryOne=s.createQuery(reqOne);
		
		// Passage des paramètres de la requête HQL
		queryOne.setParameter("pNom", "TOTO");
		queryOne.setParameter("pPrenom", "Titi");
		
		System.out.println("\n------------ Un seul employé avec HQL");
		// Exécuter la requête HQL
		Employe emp = (Employe) queryOne.uniqueResult();
		
		System.out.println(emp);
		
	}

}
