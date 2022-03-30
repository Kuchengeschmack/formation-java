package fr.adaming.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
@SuppressWarnings("serial")
public class Commande implements Serializable {

	// --1: Declaration des attributs de Commande.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private Long idCommande;
	@Column(name = "date_commande")
	private Date dateCommande;

	// Pour l association bidirectionnelle (Dans la classe client il y a un
	// attibut commande)

	@OneToMany(mappedBy = "commande")
	private Collection<LigneCommande> ligne;

	@ManyToOne
	@JoinColumn(name = "id_client", referencedColumnName = "id_client")
	private Client client;

	// --2: Appel des constructeurs

	// -a: Constructeur sans paramètres

	public Commande() {
		super();
	}

	// -b: Constructeur sans id avec autres paramètres

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	// -c: Constructeur avec id et paramètres

	public Commande(Long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	// --3: Getters et Setters

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Collection<LigneCommande> getLigne() {
		return ligne;
	}

	public void setLigne(Collection<LigneCommande> ligne) {
		this.ligne = ligne;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
