package fr.adaming.modele;

import java.util.Scanner;

public abstract class Scolaire extends Personne {

	protected String nomEtablissement;
	protected String niveau;
	
	public Scolaire(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Votre établissement : ");
		nomEtablissement = sc.next();
		System.out.println("Niveau (Primaire, Secondaire, Supérieur) : ");
		niveau = sc.next();
		if(niveau.equals("Primaire") || niveau.equals("Secondaire") || niveau.equals("Supérieur")) {
			
		} else {
			this.niveau = null;
		}
	}
	
	public Scolaire(String nomEtablissement, String niveau) {
		this.nomEtablissement = nomEtablissement;
		if(niveau.equals("Primaire") || niveau.equals("Secondaire") || niveau.equals("Supérieur")) {
			this.niveau = niveau;
		} else {
			this.niveau = null;
		}
		
	}
}
