package fr.adaming.modele;

import java.util.Scanner;

public class Reservation {

	private String categorie; // Balcon, fosse, etc.
	private int nbplaces;
	private double montant;
	
	public Reservation() {
		
		String categorie;
		int nbplaces;
		Scanner sc = new Scanner(System.in);
		categorie = sc.next();
		nbplaces = sc.nextInt();

		this.nbplaces = nbplaces;
		this.categorie = categorie;
		
		switch (categorie) {
		case "balcon":
			this.montant = nbplaces * 50;
			break;
		case "mezzanine":
			this.montant = nbplaces * 40;
			break;
		case "gradin":
			this.montant = nbplaces * 20;
			break;
		case "parterre":
			this.montant = nbplaces * 5;
			break;
		default:
			this.categorie = "";
			this.montant = 0;
		}
	}

	@Override
	public String toString() {
		return "Reservation [categorie=" + categorie + ", nbplaces=" + nbplaces + ", montant=" + montant + "]";
	}
	
}
