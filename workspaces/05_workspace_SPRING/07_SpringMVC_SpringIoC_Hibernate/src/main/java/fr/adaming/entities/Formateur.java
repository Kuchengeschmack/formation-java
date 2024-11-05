package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "formateurs")
public class Formateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_f")
	private int id;
	private String mail;
	private String password;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;

	// Transformation de l'association UML en Java
	@OneToMany(mappedBy = "formateur")
	private List<Etudiant> etudiants;

	// Transformation de l'association UML en Java
	@OneToMany(mappedBy = "formateur")
	private List<Role> roles;

	//
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

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
