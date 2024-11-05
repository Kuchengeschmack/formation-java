package fr.adaming.vue.swing;

import fr.adaming.service.CompteEpargneServiceImpl;

public class PanelCompteEpargne extends PanelCompteCourant {

	private static final long serialVersionUID = 1L;

	// Redéfinition de la méthode pour gérer des comptes épargne cette fois
	@Override
	protected void setCompteService() {
		compteService = new CompteEpargneServiceImpl();
	}
	
	
}
