package fr.adaming.vue.swing;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;

	public FenetrePrincipale() {

		// Appel du constructeur de la classe mère
		super("Gestion bancaire");

		// Paramètrage de la fenêtre : action de la croix rouge, taille, positionnement
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null); // Positionner par rapport à l'objet Bureau (=null)

		// Déclaration du panel, et configuration du layout
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		// Déclaration des boutons
		PanelClient panelClient = new PanelClient();
		PanelCompteCourant panelCourant = new PanelCompteCourant();
		PanelCompteEpargne panelEpargne = new PanelCompteEpargne();

		panelCourant.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Comptes courants",
				TitledBorder.CENTER, TitledBorder.TOP));
		panelEpargne.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Comptes épargne",
				TitledBorder.CENTER, TitledBorder.TOP));
		panelClient.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Comptes client",
				TitledBorder.CENTER, TitledBorder.TOP));

		// Ajout des sous-Panels au Panel principal
		contentPane.add(Box.createVerticalStrut(20));
		contentPane.add(panelCourant);
		contentPane.add(Box.createVerticalStrut(50));
		contentPane.add(panelEpargne);
		contentPane.add(Box.createVerticalStrut(50));
		contentPane.add(panelClient);

	}
}
