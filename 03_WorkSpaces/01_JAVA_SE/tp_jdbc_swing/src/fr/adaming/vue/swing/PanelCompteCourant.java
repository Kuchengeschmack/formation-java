package fr.adaming.vue.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import fr.adaming.modele.Compte;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.ICompteService;

public class PanelCompteCourant extends JPanel {

	private static final long serialVersionUID = 1L;

	protected Box boxY;
	protected Box boxX1;
	protected Box boxX2;
	protected Object[][] data;
	protected List<Compte> listeCompte;
	protected JTable table;
	protected JButton[] button;

	protected JTextField[] text;

	protected ICompteService compteService;

	public PanelCompteCourant() {

		// Appel du constructeur de la classe mère
		super();

		this.setCompteService();

		this.setTable();

		this.setTextFields();

		this.setButtons();

		this.setMiseEnPage();

	}

	protected void setCompteService() {
		compteService = new CompteCourantServiceImpl();
	}

	// Construit la Jtable pour afficher la table SQL correspondante
	protected void setTable() {
		listeCompte = compteService.getAllCompteService();

		data = new Object[listeCompte.size()][3];
		for (int i = 0; i < listeCompte.size(); i++) {
			data[i][0] = listeCompte.get(i).getNumCompte();
			data[i][1] = listeCompte.get(i).getSolde();
			data[i][2] = listeCompte.get(i).getNumClient();
		}

		String[] columnNames = { "N° compte", "Solde", "N° client" };

		table = new JTable(data, columnNames) {

			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(
						Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	protected void setTextFields() {
		text = new JTextField[3];
		text[0] = new JTextField("N° Compte", 10);
		text[1] = new JTextField("Solde", 10);
		text[2] = new JTextField("N° Client", 10);

		text[0].setMaximumSize(text[0].getPreferredSize());
		text[1].setMaximumSize(text[1].getPreferredSize());
		text[2].setMaximumSize(text[2].getPreferredSize());

		text[0].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[0].setText("");
			}

			public void focusLost(FocusEvent e) {

			}
		});

		text[1].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[1].setText("");
			}

			public void focusLost(FocusEvent e) {

			}
		});

		text[2].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[2].setText("");
			}

			public void focusLost(FocusEvent e) {
				
			}
		});

	}

	// Création des boutons et paramétrage des ActionEvents
	protected void setButtons() {
		// Initialisation des boutons
		button = new JButton[8];
		button[0] = new JButton("Ajouter");
		button[1] = new JButton("Supprimer");
		button[2] = new JButton("Modifier");
		button[3] = new JButton("Rechercher par N° de compte");
		button[4] = new JButton("Recherche par N° client");
		button[5] = new JButton("Retirer");
		button[6] = new JButton("Déposer");
		button[7] = new JButton("Effectuer un virement");

		// Déclaration des actionListeners pour les boutons
		// button[0]
		button[0].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouter();
				refresh();
			}

		});

		// button[1]
		button[1].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				supprimer();
				refresh();
			}

		});

		// button[2]
		button[2].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifier();
				refresh();
			}

		});

		button[3].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechercherParNumCompte();
				refresh();
			}

		});

		button[4].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechercherParNumClient();
				refresh();
			}

		});

		button[5].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				retirer();
				refresh();
			}

		});

		button[6].addActionListener(new ClickListenerCompte(compteService, table, text, listeCompte) {
			@Override
			public void actionPerformed(ActionEvent e) {
				deposer();
				refresh();
			}

		});

	}

	// Mise en page du JPanel
	protected void setMiseEnPage() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		boxY = Box.createVerticalBox();
		boxX1 = Box.createHorizontalBox();
		boxX2 = Box.createHorizontalBox();

		// Ajout des éléments au PanelCompte
		boxY.add(table.getTableHeader());
		boxY.add(table);
		this.add(boxY);
		boxX1.add(text[0]);
		boxX1.add(text[1]);
		boxX1.add(text[2]);
		this.add(boxX1);
		boxX2.add(button[0]);
		boxX2.add(button[1]);
		boxX2.add(button[2]);
		boxX2.add(button[3]);
		boxX2.add(button[4]);
		boxX2.add(button[5]);
		boxX2.add(button[6]);
		boxX2.add(button[7]);
		this.add(boxX2);
	}

	protected void refresh() {

		// On supprime tout
		this.removeAll();

		// On redéfinit tout
		this.setCompteService();
		this.setTable();
		//this.setTextFields();
		//this.setButtons();
		this.setMiseEnPage();

		// On appelle à l'actualisation de la JFrame
		this.revalidate();
		this.repaint();

	}
}
