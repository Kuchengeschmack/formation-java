package fr.adaming.entites;

import java.util.List;

public class Formateur {

	// Déclaration des attributs
	private int id;
	private String mail;
	private String password;
	
	private List<Etudiant> etudiants;
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Formateur() {
		super();
	}
	public Formateur(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	public Formateur(int id, String mail, String password) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
	}
	
	// Déclaration des getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Rédéfinition de la méthode toString
	@Override
	public String toString() {
		return "Formateur [id=" + id + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
}
