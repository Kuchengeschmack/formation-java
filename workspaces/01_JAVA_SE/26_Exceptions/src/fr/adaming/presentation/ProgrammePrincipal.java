package fr.adaming.presentation;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		
		// 1 --- On g�n�re des exceptions de type RunTimeException
		// a - la division par 0
//		int a = 14;
//		int b = 0;
//		int h = a/b;
		
		// b - d�passer la taille d'un tableau
//		int[] tab = {1,2,3};
//		
//		tab[10] = 35;
		
		// c - utiliser un objet non-instanci� : java.lang.NullPointerException
//		
//		String s = null;
//		System.out.println(s.length());
		
		// 2 ---- Traitement des exceptions avec les bloc try catch
		
		try {
			System.out.println("\n--- D�but du bloc try");
			String s = "abc";
			System.out.println(s.length());
			
			int a = 14;
			int b = 12;
			int h = a/b;
			
			int[] tab = {1,2,3};
			
			tab[10] = 45;
			
			
			System.out.println("\n--- Fin du bloc try");
		} catch(NullPointerException ex) {
			System.out.println("Le bloc catch : traitemnt sp�cifique de l\'exception (la d�viation).");
		} catch(ArithmeticException ex) {
			System.out.println("Je suis dans le deuxi�me catch.");
		} catch(Exception ex) {
			System.out.println("Le catch g�neral.");
		} finally {
			System.out.println("\n--- Je suis dans le bloc finally.");
		}
		
		System.out.println("\n---- Fin du programme");
		
		// Ce qui s'affiche en rouge dans la console est appel�e la StackTrace
		// Y sont d�crites le type et la cause de l'exception
	}

}
