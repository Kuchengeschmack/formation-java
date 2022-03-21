package fr.adaming.entities;

public abstract class Compte {
	
	protected int id;
	
	protected Double solde;

	protected Client client;
	
	// Déclaration des constructeurs

		public Compte() {
			super();
		}

		public Compte(Double solde) {
			this.solde = solde;
		}

		public Compte(int id) {
			this.id = id;
		}

		public Compte(int id, Double solde) {
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
