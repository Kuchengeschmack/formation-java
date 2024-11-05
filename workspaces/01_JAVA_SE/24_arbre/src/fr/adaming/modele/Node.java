package fr.adaming.modele;

public class Node {
	private int valeur;
	private Node left;
	private Node right;
	
	public Node(int valeur, Node left, Node right) {
		this.valeur = valeur;
		this.left = left;
		this.right = right;
	}
	
	public Node find(int v) {
		
		if(v < valeur) {
			if(left != null) {
				return left.find(v);
			}
			return null;
		} else if (v > valeur) {
			if(right != null) {
				return right.find(v);
			}
			return null;
		} else { // Si v == valeur
			return this;
			}
	}
	
	public int getValeur() {
		return valeur;
	}
}
