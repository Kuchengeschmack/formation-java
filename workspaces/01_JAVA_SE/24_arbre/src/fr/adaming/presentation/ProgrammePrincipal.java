package fr.adaming.presentation;

import fr.adaming.modele.Node;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Etage 3
		Node n2 = new Node(2, null, null);
		Node n6 = new Node(6, null, null);
		Node n16 = new Node(16, null, null);
		
		// Etage 2
		Node n5 = new Node(5, n2, n6);
		Node n8 = new Node(8, null, null);
		Node n17 = new Node(17, n16, null);
		
		// Etage 1
		Node n7 = new Node(7, n5, n8);
		Node n13 = new Node(13, null, n17);
		
		// racine
		Node small = new Node(9, n7, n13);
		
		System.out.println(small.find(10));
		
	}

}
