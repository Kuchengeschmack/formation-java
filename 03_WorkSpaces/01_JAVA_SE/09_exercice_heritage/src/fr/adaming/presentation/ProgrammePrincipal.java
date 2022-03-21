package fr.adaming.presentation;

import fr.adaming.modele.*;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		B b1 = new B();
		B b2 = new B(2003);
		B b3= new B("Bonjour");
		System.out.println(b1.x + " et " + b2.x + " et encore " + b3.x);

	}

}
