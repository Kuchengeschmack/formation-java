package fr.adaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@"SELECT * FROM clients WHERE courriel=? AND mdp=?"
@Entity

@Table(name = "clients")

public class Client {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "courriel")
	private String courriel;

	@Column(name = "mdp")
	private String mdp;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "code_postal")
	private int codePostal;

	@Column(name = "ville")
	private String ville;

	@Column(name = "telephone")
	private int telephone;

	// Relations entre tables

	@OneToOne
	@JoinColumn(name = "compte_courant_id", referencedColumnName = "id")
	private CompteCourant compteCourant;

	@OneToOne
	@JoinColumn(name = "compte_epargne_id", referencedColumnName = "id")
	private CompteEpargne compteEpargne;

	// Déclaration des constructeurs

	public Client() {
		super();
	}

	public Client(String courriel, String mdp, String nom, String prenom, String adresse, int codePostal, String ville,
			int telephone, CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super();
		this.courriel = courriel;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	public Client(int id, String courriel, String mdp, String nom, String prenom, String adresse, int codePostal,
			String ville, int telephone, CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super();
		this.id = id;
		this.courriel = courriel;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	public Client(int id, String courriel, String mdp, String nom, String prenom, String adresse, int codePostal,
			String ville, int telephone) {
		super();
		this.id = id;
		this.courriel = courriel;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	public Client(String courriel, String mdp, String nom, String prenom, String adresse, int codePostal, String ville,
			int telephone) {
		super();
		this.courriel = courriel;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	public Client(int id, String courriel, String mdp) {
		this.id = id;
		this.courriel = courriel;
		this.mdp = mdp;
	}

	public Client(String courriel, String mdp) {
		this.courriel = courriel;
		this.mdp = mdp;
	}

	// Déclaration des getters et setters

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", courriel=" + courriel + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone="
				+ telephone + ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + "]";
	}

}
