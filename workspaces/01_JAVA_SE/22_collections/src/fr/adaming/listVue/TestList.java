package fr.adaming.listVue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// D�claration et instanciation d'un objet de type ArrayList
		List<String> maListe = new ArrayList<>(); // A chaque fois qu'une classe impl�mente une interface, on essaye de typer ses objets par son interface
		
		maListe.add("TOTO");
		maListe.add("FOFO");
		maListe.add("RORO");
		
		// R�cup�rer la taille de la liste
		System.out.println("la taille de ma liste est " + maListe.size());
		
		// R�cup�rer un �l�ment � un indice donn�
		System.out.println("L\'�l�ment � la position 1 de ma liste est " + maListe.get(1));
		
		// Ins�rer un �l�m�nt � un indice donn�
		maListe.add(2, "YOYO");
		
		System.out.println(maListe.get(3));
		
		// Modifier la valeur d'un �l�ment � un index donn�
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
		while(it.hasNext()) { // tant que l'it�rateur n'a pas atteint la fin de la liste
			// D�placer le curseur et r�cu�rer l'�l�ment
			String elem = it.next();
			System.out.println(elem);
		}
	}

}
