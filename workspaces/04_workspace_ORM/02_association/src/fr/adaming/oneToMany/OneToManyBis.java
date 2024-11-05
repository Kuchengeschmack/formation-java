package fr.adaming.oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyBis {

	public static void main(String[] args) {
		// Cr�ation d'un EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_association");

		// Cr�ation d'un EntityManager
		EntityManager em = emf.createEntityManager();

		// R�cup�rer une biblioth�que
		Bibliotheque b1 = em.find(Bibliotheque.class, 1);

		System.out.println(b1);

		System.out.println("\n---------------------------------------------------------");

		for (Livre l : b1.getLivres()) {
			System.out.println(l);
		}
	}
}
