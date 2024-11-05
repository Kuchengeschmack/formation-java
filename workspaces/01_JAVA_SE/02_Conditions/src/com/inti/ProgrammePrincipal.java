package com.inti;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		double moyenne = 9;

		if (moyenne > 10) {

			System.out.println("Bravo, vous avez reussi !");
		} else if (moyenne == 10) {
			System.out.println("Vous devez faire plus d'efforts !");
		} else {
			System.out.println("Tant pis ! vous revenez l'année prochaine !");
		}

		String nom = "TOTO";

		switch (nom) {
		case "TOTO":
			System.out.println("Bonjour TOTO");
			break;
		case "nomane":
			System.out.println("Bonjour nomane");
			break;
		default:
			System.out.println("Désolé ! je ne vous connais pas !");
			break;
		}

		// condition ternaire
		int y = 30;
		int w = 20;
		int z = (y < w) ? 2 * w : 4 * w;

//		if(y<w) {
//			z=2*w;
//		}else {
//			z=4*w;
//		}

		System.out.println(z);
	}

}
