package fr.adaming.modele;

import java.util.Scanner;

public abstract class Scolaire extends Personne {

	protected String nomEtablissement;
	protected String niveau;
	
	public Scolaire(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Votre �tablissement : ");
		nomEtablissement = sc.next();
		System.out.println("Niveau (Primaire, Secondaire, Sup�rieur) : ");
		niveau = sc.next();
		if(niveau.equals("Primaire") || niveau.equals("Secondaire") || niveau.equals("Sup�rieur")) {
			
		} else {
			this.niveau = null;
		}
	}
	
	public Scolaire(String nomEtablissement, String niveau) {
		this.nomEtablissement = nomEtablissement;
		if(niveau.equals("Primaire") || niveau.equals("Secondaire") || niveau.equals("Sup�rieur")) {
			this.niveau = niveau;
		} else {
			this.niveau = null;
		}
		
	}
}
