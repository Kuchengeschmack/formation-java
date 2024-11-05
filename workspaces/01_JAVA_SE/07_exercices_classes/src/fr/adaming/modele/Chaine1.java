package fr.adaming.modele;

public class Chaine1 {

	// Attributs
	
	private String str;
	private StringBuilder voy;
	private StringBuilder con;
	
	// Constructeur
	
	public Chaine1() {
		voy = new StringBuilder();
		con = new StringBuilder();
	}
	
	public Chaine1(String str) {
		this.str = str;
		voy = new StringBuilder();
		con = new StringBuilder();
	}
	
	// Getters et Setters
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public StringBuilder getVoy() {
		return voy;
	}

	public StringBuilder getCon() {
		return con;
	}
	
	// Méthodes
	
	public void extraction() {
		
		String voyelles = "AEIOUaeiou";
		String consonnes = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmpqrstvwxyz";
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < voyelles.length(); j++) {
				if(str.charAt(i) == voyelles.charAt(j)) {
					voy.append(str.charAt(i));
				}
			
			}

		}
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < consonnes.length(); j++) {
				if(str.charAt(i) == consonnes.charAt(j)) {
					con.append(str.charAt(i));
				}
			
			}

		}
	
	}


}