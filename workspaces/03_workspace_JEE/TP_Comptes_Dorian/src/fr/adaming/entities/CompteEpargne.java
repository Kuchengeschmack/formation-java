package fr.adaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "compte_epargne")

public class CompteEpargne extends Compte {

	public static final Double taux = 0.03;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "solde")
	private Double solde;

	@OneToOne(mappedBy = "compteCourant")
	private Client client;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(Double solde) {
		this.solde = solde;
	}

	public CompteEpargne(int id) {
		this.id = id;
	}

	public CompteEpargne(int id, Double solde) {
		this.id = id;
		this.solde = solde;
	}

	// Déclaration des getters et setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
