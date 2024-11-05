package fr.adaming.presentation;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		
		int[] tab = {1,9,5,8,2,3,0,1,2};
		int n = 5;
		double d = 4;
		int[] dividende = new int[2];
		
//		// Ex1
//		System.out.println(ex1(n, tab));
//		cc
//		// Ex2
//		System.out.println(ex2(n, tab));
//
//		// Ex3
//		System.out.println(ex3(n, tab));
//		
//		// Ex4
//		System.out.println(ex4(n, 3, tab));
//		
//		// Ex5
//		ex5(dividende,d);
//		System.out.println(ex5(tab, d));
//		
//		// Ex6
//		for(int i = 0; i < tab.length; i++) {
//			System.out.println(ex6(tab)[i]);
//		}
//		
//		// Ex7
//		System.out.println(ex7(tab));
//		
//		// Ex8
//		ex8(tab, 1, 3);
//		
//		// Ex9 et Ex10
//		System.out.println(ex9(tab));
//		System.out.println(ex10(tab));
//		
//		// Ex11
//		ex11(tab);
//		
//		// Ex12
//		System.out.println(ex12("les chaussettes de la duchesse sont-elles sèches ou archi-sèches", 's'));
		
	}
	
	public static boolean ex1(int n, int[] tab){
		for(int elem : tab) {
			if(elem == n) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean ex2(int n, int[] tab){
		
		int indice = -1;
		
		for(int i = 0; i < tab.length; i++) {
			if(tab[i] == n) {
				indice = i;
			}
			
		}
		if(indice == -1) {
			return false;
		} else {
			System.out.println("La dernière occurence de l\'entier " + n + " est en position " + indice);
			return true;
		}
	}

	public static boolean ex3(int n, int[] tab){
		
		for(int i = 0; i < tab.length; i++) {
			if(tab[i] == n) {
				System.out.println("La première occurence de l\'entier " + n + " est en position " + i);
				return true;
				}
		}
		return false;
		
	}
	
	public static boolean ex4(int n, int indice, int[] tab){
		
		if(indice < tab.length && indice > -1) {
			for(int elem : tab) {
				System.out.println(elem);
			}
			tab[indice] = n;
			System.out.println("\n");
			for(int elem : tab) {
				System.out.println(elem);
			}
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public static double ex5(int[] tab, double diviseur){
		
		
		double dividende = 0;
		int nb = tab.length - 1;
		// On construit le dividende qui est un double
		for(int i = 0; i < tab.length; i++) {
			dividende += tab[i] * Math.pow(10, nb - i);
		}
		
		return dividende/diviseur;

	}

	public static int[] ex6(int[] tab) {
		
		int[] occurence = new int[tab.length];
		
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[j] == tab[i]) {
					occurence[j]++;
					}
				}
			}
		return occurence;
		}

	public static double ex7(double[] tab) {
		double moy = 0;
		for(double elem : tab) {
			moy += elem;
		}
		moy /= tab.length;
		return moy;
	}

	public static void ex8(int[] tab, int i, int j) {
		
		int temp;
		
		for(int elem : tab) {
			System.out.println(elem);
		}
		
		temp = tab[i];
		tab[i] = tab[j];
		tab[j] = temp;
		
		System.out.println("\n");
		
		for(int elem : tab) {
			System.out.println(elem);
		}
		
	}

	public static int ex9(int[] tab) {
		
		int max = tab[0];
		for(int elem : tab) {
			if(elem > max) {
				max = elem;
			}
		}
		return max;
	}
	
	public static int ex10(int[] tab) {
		
		int min = tab[0];
		for(int elem : tab) {
			if(elem < min) {
				min = elem;
			}
		}
		return min;
	}

	public static void ex11(int[] tab) {
		
		for(int elem : tab) {
			System.out.println(elem);
		}
		
		for(int i = 0; i < tab.length; i++) {
			for(int j = i; j < tab.length; j++) {
				if(tab[j] < tab[i]) {
					int temp;
					
					temp = tab[i];
					tab[i] = tab[j];
					tab[j] = temp;
					}
				}
			}
		System.out.println("\n");
		
		for(int elem : tab) {
			System.out.println(elem);
		}
	}
	
	public static int ex12(String str, char lettre) {
		
		int compteur = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == lettre) {
				compteur++;
			}
		}
		
		return compteur;
	}
	
}
