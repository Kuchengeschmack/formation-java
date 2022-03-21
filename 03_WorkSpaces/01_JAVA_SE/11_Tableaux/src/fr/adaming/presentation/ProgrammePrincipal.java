package fr.adaming.presentation;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		int[] tab;
		
		tab = new int[5];
		
		System.out.println("la taille de tab est : " + tab.length);

		tab[0] = 14;
		
		System.out.println("l'élément à l\'index 0 est : " + tab[0]);
		
		String[] semaine = {"Lundi", "Mardi", "Mercredi", "Jeudi"};
		
		System.out.println("la taille du tableau semaine : " + semaine.length);
		
		System.out.println(semaine);
		
		for(int i = 0; i < semaine.length; i++) {
			
			System.out.println(semaine[i]);
		}
		
		// parcourir le tableau avec une boucle forEach
		for(String elem : semaine) {
			System.out.println(elem + " , ");
		}
		
		int[][] tab1 = new int[3][2];
		
		int[][] tab2 = {{1,2}, {3,4}, {5,6}};
		
		for(int i = 0; i < tab2.length; i++) {
			for(int j = 0; j < tab2[0].length; j++) {
				System.out.println(tab2[i][j]);
			}
		}
		
		for(int[] elem : tab2) {
			for(int val : elem) {
				System.out.println(val);
			}
		}
	}

}
