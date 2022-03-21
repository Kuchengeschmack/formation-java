package fr.adaming.presentation;

import fr.adaming.service.MaClasse;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaClasse<String> mc = new MaClasse<>();
		
		mc.modifier("TOTO");
		
		MaClasse<Integer> mc1 = new MaClasse<>();
		mc1.modifier(1234);
		
		MaClasse<Object> mc2 = new MaClasse<Object>();
		
	}

}
