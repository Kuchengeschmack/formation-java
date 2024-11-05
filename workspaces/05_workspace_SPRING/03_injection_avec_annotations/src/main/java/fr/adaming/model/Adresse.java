package fr.adaming.model;

import org.springframework.beans.factory.annotation.Value;

public class Adresse {

	// D�claration des attributs
	@Value(value = "Paris") // Cette annotation permet d'injecter des valeurs simples (types pri
	private String ville;
	@Value(value = "Alexandre Dumas")
	private String rue;

	// D�claration des constructeurs
	public Adresse() {
		super();
	}

	public Adresse(String ville, String rue) {
		super();
		this.ville = ville;
		this.rue = rue;
	}

	// D�claration des getters et setters
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	// Red�finition de toString
	@Override
	public String toString() {
		return "Adresse [ville=" + ville + ", rue=" + rue + "]";
	}

}
