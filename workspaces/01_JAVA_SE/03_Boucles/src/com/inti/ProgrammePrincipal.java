package com.inti;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// la boucle for : on l'utilise quand on conna�t le nombre d'it�rations � faire

		// Le mot clef continue sert � arr�ter l'it�ration et recommencer une nouvelle
		// Le mot clef break sert � arr�ter compl�tement la boucle

		String s = "TOTO � Paris !";
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ' ') {
				continue; // Arr�te l'it�ration et passe � la suivante
			}

			System.out.println(s.charAt(i));
		}

		// imbriquer les boucles for

		etq: for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 3; j++) {

				if (i == 2 && j == 1) {
					break etq;
				}

				System.out.println("( " + i + ", " + j + " )");
			}
			System.out.println("\n");
		}

		// on utilise les boucles while et do while quand on ne conna�t pas le nombre
		// d'it�rations � l'avance
		// while
		int k = 0;

		while (k < 10) {
			System.out.println(k);
			k++;
		}

		// do while

		// do while : le bloc de do while est execut� au moins une fois
		int h = 11;
		do {
			System.out.println(h);
			h++;
		} while (h < 10);

	}

}
