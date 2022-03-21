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

import fr.adaming.modele.Client;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

public class PanelClient extends JPanel {

	private static final long serialVersionUID = 1L;

	private Box boxY;
	private Box boxX1;
	private Box boxX2;
	private Object[][] data;
	private List<Client> listeClient;
	private JTable table;
	private JButton[] button;
	
	private JTextField[] text;

	IClientService clientService;

	public PanelClient() {

		// Appel du constructeur de la classe mère
		super();
		
		this.setClientService();

		this.setTable();

		this.setTextFields();

		this.setButtons();

		this.setMiseEnPage();

	}

	private void setTextFields() {
		text = new JTextField[7];
		text[0] = new JTextField("N° Client", 10);
		text[1] = new JTextField("Nom", 10);
		text[2] = new JTextField("Prénom", 10);
		text[3] = new JTextField("Adresse", 10);
		text[4] = new JTextField("CP", 10);
		text[5] = new JTextField("Ville", 10);
		text[6] = new JTextField("Tél.", 10);

		text[0].setMaximumSize(text[0].getPreferredSize());
		text[1].setMaximumSize(text[1].getPreferredSize());
		text[2].setMaximumSize(text[2].getPreferredSize());
		text[3].setMaximumSize(text[3].getPreferredSize());
		text[4].setMaximumSize(text[4].getPreferredSize());
		text[5].setMaximumSize(text[5].getPreferredSize());
		text[6].setMaximumSize(text[6].getPreferredSize());

		text[0].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[0].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[0].getText().equals("")) {
					text[0].setText("N° Client");
				}
			}
		});

		text[1].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[1].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[1].getText().equals("")) {
					text[1].setText("Nom");
				}
			}
		});

		text[2].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[2].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[2].getText().equals("")) {
					text[2].setText("Prénom");
				}
			}
		});
		
		text[3].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[3].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[3].getText().equals("")) {
					text[3].setText("Adresse");
				}
			}
		});
		
		text[4].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[4].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[4].getText().equals("")) {
					text[4].setText("CP");
				}
			}
		});
		
		text[5].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[5].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[5].getText().equals("")) {
					text[5].setText("Ville");
				}
			}
		});
		
		text[6].addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				text[6].setText("");
			}

			public void focusLost(FocusEvent e) {
				if (text[6].getText().equals("")) {
					text[6].setText("Tél.");
				}
			}
		});

		
	}

	private void setClientService() {
		clientService = new ClientServiceImpl();
		
	}

	// Construit la Jtable pour afficher la table SQL correspondante
	private void setTable() {
		listeClient = clientService.getAllClientService();

		data = new Object[listeClient.size()][7];
		for (int i = 0; i < listeClient.size(); i++) {
			data[i][0] = listeClient.get(i).getNumClient();
			data[i][1] = listeClient.get(i).getNom();
			data[i][2] = listeClient.get(i).getPrenom();
			data[i][3] = listeClient.get(i).getAdresse();
			data[i][4] = listeClient.get(i).getCodePostal();
			data[i][5] = listeClient.get(i).getVille();
			data[i][6] = listeClient.get(i).getNumTelephone();
		}

		String[] columnNames = { "N° Client", "Nom", "Prénom", "Adresse", "Code Postal", "Ville", "Tél." };

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

	// Création des boutons et paramétrage des ActionEvents
	private void setButtons() {
		button = new JButton[4];
		// Initialisation des boutons
		button[0] = new JButton("Ajouter");
		button[1] = new JButton("Supprimer");
		button[2] = new JButton("Modifier");
		button[3] = new JButton("Rechercher");

		// Déclaration des actionListeners 1 par bouton
		// button1 ...
		button[0].addActionListener(new ClickListenerClient(clientService, table, text, listeClient) {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouter();
				refresh();
			}
		});

		button[1].addActionListener(new ClickListenerClient(clientService, table, text, listeClient) {
			@Override
			public void actionPerformed(ActionEvent e) {
				supprimer();
				refresh();
			}
		});
		
		button[2].addActionListener(new ClickListenerClient(clientService, table, text, listeClient) {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifier();
				refresh();
			}
		});

	}

	// Mise en page du JPanel
	private void setMiseEnPage() {

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
		boxX1.add(text[3]);
		boxX1.add(text[4]);
		boxX1.add(text[5]);
		boxX1.add(text[6]);
		this.add(boxX1);
		boxX2.add(button[0]);
		boxX2.add(button[1]);
		boxX2.add(button[2]);
		boxX2.add(button[3]);
		this.add(boxX2);
	}

	private void refresh() {
		// On supprime tout
		this.removeAll();
		
		// On redéfinit tout		
		this.setClientService();
		this.setTable();
		this.setTextFields();
		this.setButtons();
		this.setMiseEnPage();
		
		// On appelle à l'actualisation de la JFrame
		this.revalidate();
		this.repaint();
	}
}
