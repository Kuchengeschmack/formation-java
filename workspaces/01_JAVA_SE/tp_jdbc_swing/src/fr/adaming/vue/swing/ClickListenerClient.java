package fr.adaming.vue.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import fr.adaming.modele.Client;
import fr.adaming.service.IClientService;

public class ClickListenerClient implements ActionListener {

	private IClientService clientService;
	private JTable table;
	private JTextField[] text;
	private List<Client> listeClient;

	public ClickListenerClient(IClientService clientService, JTable table, JTextField[] text,
			List<Client> listeClient) {
		this.clientService = clientService;
		this.table = table;
		this.text = text;
		this.listeClient = listeClient;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// A redéfinir lors de l'instanc iation de l'objet
	}

	public void ajouter() {
		int numClient = Integer.parseInt(text[0].getText());
		String nom = text[1].getText();
		String prenom = text[2].getText();
		String adresse = text[3].getText();
		int codePostal = Integer.parseInt(text[4].getText());
		String ville = text[5].getText();
		int numTelephone = Integer.parseInt(text[6].getText());

		Client c = new Client(numClient, nom, prenom, adresse, codePostal, ville, numTelephone);

		clientService.ajouterClientService(c);
	}

	public void supprimer() {
		int index = table.getSelectedRow(); // renvoie l'index de l'élément sélectionné dans la liste
		if (index > -1)

		{
			Client c = listeClient.get(index); // Objet représentant le compté sélectionné
			clientService.supprimerClientService(c.getNumClient());
		}
	}

	public void modifier() {
		int numClient = Integer.parseInt(text[0].getText());
		String nom = text[1].getText();
		String prenom = text[2].getText();
		String adresse = text[3].getText();
		int codePostal = Integer.parseInt(text[4].getText());
		String ville = text[5].getText();
		int numTelephone = Integer.parseInt(text[6].getText());

		Client c = new Client(numClient, nom, prenom, adresse, codePostal, ville, numTelephone);

		clientService.modifierClientService(c);
	}
}