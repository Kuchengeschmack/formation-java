import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyWindow() {
		super("My First Swing Application"); // Appel du constructeur de JFrame
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("Poussez-moi"));
		contentPane.add(new JButton("Clique!!!!!!!!!!!!!!!!!!!!"));
		contentPane.add(new JCheckBox("Cochez-moi"));
		contentPane.add(new JTextField("Éditez-moi"));

	}

	public static void main(String[] args) throws Exception {
		// Apply a look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());

		// Start my window
		MyWindow myWindow = new MyWindow();
		myWindow.setVisible(true);

	}

}
