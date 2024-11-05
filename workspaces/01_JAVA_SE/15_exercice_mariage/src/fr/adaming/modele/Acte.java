package fr.adaming.modele;

public class Acte {

	private Personne c1;
	private Personne c2;
	private Mairie m;
	
	public Acte(Mairie m, Personne c1, Personne c2) {
		this.c1 = c1;
		this.c2 = c2;
		this.m = m;
	}
	
	public Personne getC1() {
		return c1;
	}
	public void setC1(Personne c1) {
		this.c1 = c1;
	}
	public Personne getC2() {
		return c2;
	}
	public void setC2(Personne c2) {
		this.c2 = c2;
	}

	public Mairie getM() {
		return m;
	}

	public void setM(Mairie m) {
		this.m = m;
	}

	// Pour retourner l'acte de mariage à afficher dans la console
	@Override
	public String toString() {
		return "Union de " + c1.getPrenom() + " " + c1.getNom() + " et " + c2.getPrenom() + " " + c2.getNom() + " à " + m.getCommune();
	}
	
	
}
