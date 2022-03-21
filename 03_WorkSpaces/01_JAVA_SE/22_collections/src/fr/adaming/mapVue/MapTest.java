package fr.adaming.mapVue;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// Déclaration et instanciation d'un objet de type map
		Map<String, Integer> monMap = new HashMap<>();
		
		Integer a1 = monMap.put("Nomane", new Integer(123));
		System.out.println(a1);
		
		Integer a2 = monMap.put("Jean", new Integer(145));
		System.out.println(a2);
		
		monMap.put("Lundi", new Integer(456));
		monMap.put("Mardi", new Integer(478));
		
		// Récupérer la taille du map
		System.out.println("La taille de monMap est : " + monMap.size());
		
		// Récupérer un élément par sa clef
		System.out.println("L\'élément associé à la clé Nomane est : " + monMap.get("Nomane"));
		
		// Modifier un élément avec ça clef
		monMap.put("Nomane", new Integer(5000));
		System.out.println("Le nouveau élément associé à la clef Nomane est : ");

		// Supprimer un élément par sa clef
		monMap.remove("Mardi");
		
		// Parcourir le map
		// Récupérer l'ensemble des clefs dans un Set
		Set<String> clefs = monMap.keySet();
		
		for(String key: clefs) {
			System.out.println(key + " : " + monMap.get(key));
		}
		
		// Parcourir l'ensemble des valeurs
		// Récupérer l'ensemble des valeurs du map
		Collection<Integer> valeurs = monMap.values();
		
		for(Integer val : valeurs) {
			System.out.println(val);
		}
		
		// Récupérer le set des paires (clef : valeur)
		Set<Map.Entry<String, Integer>> paires = monMap.entrySet();
		for(Map.Entry<String, Integer> elem : paires) {
			System.out.println(elem.getKey() + " : " + elem.getValue());
		}
		
	}

}
