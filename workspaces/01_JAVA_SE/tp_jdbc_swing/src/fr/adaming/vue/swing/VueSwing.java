package fr.adaming.vue.swing;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class VueSwing {

	public static void lancerSwing() throws UnsupportedLookAndFeelException {

		// Look N'Feel pas trop d�gueux
		UIManager.setLookAndFeel(new NimbusLookAndFeel());

		// Instanciation de la fen�tre principale
		FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
		fenetrePrincipale.setVisible(true);
		
	}
}
