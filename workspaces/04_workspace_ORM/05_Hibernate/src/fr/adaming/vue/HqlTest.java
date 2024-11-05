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

		// R�cup�rer la SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		// R�cup�rer la session
		Session s = sf.openSession();

		// La liste des employ�s avec HQL
		// �crire la requ�te HQL
		String reqListeHql = "FROM Employe as e";

		// R�cup�rer l'objet Query afin d'executer la requ�te HQL
		Query queryListeHql = s.createQuery(reqListeHql);

		System.out.println("------------------ liste avec HQL");
		// Ex�cuter la requ�te HQL et r�cup�rer la liste
		List<Employe> listeHql = queryListeHql.list();

		listeHql.forEach(System.out::println);

		// ================ La liste des noms avec HQL
		// �crire la requ�te HQL
		String reqNoms = "SELECT e.nom FROM Employe e";
		
		// R�cup�rer l'objet Query afin d'executer la requ�te SQL
		Query queryNomsHql = s.createQuery(reqNoms);
		
		System.out.println("\n----------- liste des noms avec HQL");
		// Ex�cuter la requ�te HQL et r�cup�rer la liste
		List<String> listeNomsHql = queryNomsHql.list();
		
		listeNomsHql.forEach(System.out::println);

		// =============== Un seul employ� avec HQL
		// �crire la requ�te HQL
		String reqOne = "FROM Employe e WHERE e.nom=:pNom AND e.prenom=:pPrenom";
		
		// R�cup�rer l'objet Query afin d'ex�cuter la requ�te HQL
		Query queryOne=s.createQuery(reqOne);
		
		// Passage des param�tres de la requ�te HQL
		queryOne.setParameter("pNom", "TOTO");
		queryOne.setParameter("pPrenom", "Titi");
		
		System.out.println("\n------------ Un seul employ� avec HQL");
		// Ex�cuter la requ�te HQL
		Employe emp = (Employe) queryOne.uniqueResult();
		
		System.out.println(emp);
		
	}

}
