package fr.adaming.listVue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Déclaration et instanciation d'un objet de type ArrayList
		List<String> maListe = new ArrayList<>(); // A chaque fois qu'une classe implémente une interface, on essaye de typer ses objets par son interface
		
		maListe.add("TOTO");
		maListe.add("FOFO");
		maListe.add("RORO");
		
		// Récupérer la taille de la liste
		System.out.println("la taille de ma liste est " + maListe.size());
		
		// Récupérer un élément à un indice donné
		System.out.println("L\'élément à la position 1 de ma liste est " + maListe.get(1));
		
		// Insérer un élémént à un indice donné
		maListe.add(2, "YOYO");
		
		System.out.println(maListe.get(3));
		
		// Modifier la valeur d'un élément à un index donné
		maListe.set(2, "Jean");
		
		// Parcourir la liste avec une boucle for
		for(int i = 0; i < maListe.size(); i++) {
			System.out.println(maListe.get(i));
		}
		
		for(String elem : maListe) {
			System.out.println(elem);
		}
		
		// Parcour avec la boucle while et l'iterator
		Iterator<String> it = maListe.iterator();
		while(it.hasNext()) { // tant que l'itérateur n'a pas atteint la fin de la liste
			// Déplacer le curseur et récuérer l'élément
			String elem = it.next();
			System.out.println(elem);
		}
	}

}
