package fr.adaming.vue.swing;

import fr.adaming.service.CompteEpargneServiceImpl;

public class PanelCompteEpargne extends PanelCompteCourant {

	private static final long serialVersionUID = 1L;

	// Red�finition de la m�thode pour g�rer des comptes �pargne cette fois
	@Override
	protected void setCompteService() {
		compteService = new CompteEpargneServiceImpl();
	}
	
	
}
