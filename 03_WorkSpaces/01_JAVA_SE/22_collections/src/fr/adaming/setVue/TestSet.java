package fr.adaming.setVue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		
		// Déclaration et instanciation d'un objet de type Set
		Set<String> monSet = new HashSet<>(); // Le plus  souvent, on type les objets par leur interface
		
		// Ajouter des éléments dans le Set
		boolean r1 = monSet.add("TOTO");
		System.out.println(r1);
		boolean r2 = monSet.add("TOTO"); // retourne false car le set n'accepte pas les doublons
		System.out.println(r2);
		
		// récupérer la taille d'un set
		System.out.println("La taille de monSet est : " + monSet.size());
		
		// Vérifier si le set contient un objet ou non
		boolean r3 = monSet.contains("TOTO");
		System.out.println(r3);
		
		monSet.add("RORO");
		monSet.add("FOFO");
		monSet.add("YOYO");
		
		// Les sets ne sont pas indexés, donc on utilise forcément une boucle forEach
		System.out.println("\n--------- Avec la boucle forEach");
		for(String elem : monSet) {
			System.out.println(elem);
		}
		
//		// Avec l'iterator
//		Iterator<String> it = new Iterator<>();
		
		// Transformer un set en un  tableau d'objets
		System.out.println("\n--------- Avec la boucle for");
		Object[] maListe = monSet.toArray();
		
		for(int i = 0; i < maListe.length; i++) {
			System.out.println(maListe[i]);
		}
		
		
	}
}
