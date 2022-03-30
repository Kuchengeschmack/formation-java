package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
@SuppressWarnings("serial")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long idClient;
	@Column(name = "nom_client")
	private String nomClient;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "email")
	private String email;
	@Column(name = "mdp")
	private String mdp;
	@Column(name = "telephone")
	private String telephone;

	// transformation de l'association UML en java
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;

	@OneToMany(mappedBy = "client")
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nomClient, String adresse, String email, String mdp, String telephone) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
	}

	public Client(Long idClient, String nomClient, String adresse, String email, String mdp, String telephone) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
	}

	// getters et setters
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}
