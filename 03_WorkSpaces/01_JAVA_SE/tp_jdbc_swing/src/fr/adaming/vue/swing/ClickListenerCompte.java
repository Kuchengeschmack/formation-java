package fr.adaming.vue.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import fr.adaming.modele.Compte;
import fr.adaming.modele.CompteCourant;
import fr.adaming.service.ICompteService;

public class ClickListenerCompte implements ActionListener {

	private ICompteService compteService;
	private JTable table;
	private JTextField[] text;
	private List<Compte> listeCompte;

	public ClickListenerCompte(ICompteService compteService, JTable table, JTextField[] text,
			List<Compte> listeCompte) {
		this.compteService = compteService;
		this.table = table;
		this.text = text;
		this.listeCompte = listeCompte;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// A redéfinir lors de l'instanc iation de l'objet
	}

	public void ajouter() {
		int numCompte = Integer.parseInt(text[0].getText());
		double solde = Double.parseDouble(text[1].getText());
		int numClient = Integer.parseInt(text[2].getText());

		CompteCourant c = new CompteCourant(numCompte, solde, numClient);

		compteService.attribuerCompteService(c);
	}

	public void supprimer() {
		int index = table.getSelectedRow(); // renvoie l'index de l'élément sélectionné dans la liste
		if (index > -1)

		{
			Compte c = listeCompte.get(index); // Objet représentant le compté sélectionné
			compteService.supprimerCompteService(c.getNumCompte());
		}
	}

	public void modifier() {
		int numCompte = Integer.parseInt(text[0].getText());
		double solde = Double.parseDouble(text[1].getText());
		int numClient = Integer.parseInt(text[2].getText());

		CompteCourant c = new CompteCourant(numCompte, solde, numClient);

		compteService.modifierCompteService(c);
	}

	public void rechercherParNumCompte() {
		int numCompte = Integer.parseInt(text[0].getText());

		Compte c = compteService.chercherIdCompteService(numCompte);

		text[1].setText(Double.toString(c.getSolde()));
		text[2].setText(Integer.toString(c.getNumClient()));

	}

	public void rechercherParNumClient() {
		int numClient = Integer.parseInt(text[2].getText());

		Compte c = compteService.chercherIdClientCompteService(numClient);

		text[0].setText(Integer.toString(c.getNumCompte()));
		text[1].setText(Double.toString(c.getSolde()));

	}

	public void retirer() {
		int numCompte = Integer.parseInt(text[0].getText());
		Double montant = Double.parseDouble(text[1].getText());

		compteService.retirerCompteService(numCompte, montant);
	}

	public void deposer() {
		int numCompte = Integer.parseInt(text[0].getText());
		Double montant = Double.parseDouble(text[1].getText());

		compteService.deposerCompteService(numCompte, montant);
	}

	public void virement() {

	}
}