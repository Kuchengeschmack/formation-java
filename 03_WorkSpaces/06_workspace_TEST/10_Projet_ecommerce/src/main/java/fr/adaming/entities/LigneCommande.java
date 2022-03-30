package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneCommandes")
@SuppressWarnings("serial")
public class LigneCommande implements Serializable {

	// --1: Declaration des attributs de Commande.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "quantite")
	private int quantite;
	@Column(name = "prix")
	private double prix;

	// Transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name = "id_produit", referencedColumnName = "id_produit")
	private Produit produit;

	// Transformation de l'association UML en Java
	@ManyToOne
	@JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
	private Commande commande;

	// --2: Appel des constructeurs

	// -a: Constructeur sans paramètres

	public LigneCommande() {
		super();
	}

	// -b: Constructeur sans id avec autres paramètres

	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	// -c: Constructeur avec id et paramètres

	public LigneCommande(Long id, int quantite, double prix) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
	}

	// --3: Getters et Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
