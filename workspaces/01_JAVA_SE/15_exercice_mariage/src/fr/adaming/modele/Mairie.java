package fr.adaming.modele;

public class Mairie {

	private String commune;
	
	public Mairie() {
		
	}
	
	public Mairie(String commune) {
		super();
		this.commune = commune;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}
	
	public Acte marier(Personne p1, Personne p2) {
		
		Acte a;
		p1.setConjoint(p2);
		p2.setConjoint(p1);
		a = new Acte(this, p1, p2);
		p1.setA(a);
		p2.setA(a);
		return a;
	}
	
	
}
