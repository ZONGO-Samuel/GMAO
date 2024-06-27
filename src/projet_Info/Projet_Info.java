package projet_Info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Projet_Info {

	private JFrame frmVeuillezCliquerSur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projet_Info window = new Projet_Info();
					window.frmVeuillezCliquerSur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Projet_Info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVeuillezCliquerSur = new JFrame();
		frmVeuillezCliquerSur.setFont(new Font("Times New Roman Special G1", Font.PLAIN, 18));
		frmVeuillezCliquerSur.setBackground(Color.BLUE);
		frmVeuillezCliquerSur.setTitle("veuillez cliquer sur votre profil");
		frmVeuillezCliquerSur.getContentPane().setForeground(Color.BLUE);
		frmVeuillezCliquerSur.getContentPane().setLayout(null);
		
		JLabel ADMINISTRATEUR = new JLabel("  ADMINISTRATEUR");
		ADMINISTRATEUR.setBounds(27, 118, 126, 14);
		frmVeuillezCliquerSur.getContentPane().add(ADMINISTRATEUR);
		
		JLabel Operateur = new JLabel("OPERATEUR");
		Operateur.setBounds(304, 118, 91, 14);
		frmVeuillezCliquerSur.getContentPane().add(Operateur);
		
		JLabel lblNewLabel = new JLabel("RESPONSABLE DE MAINTENACE");
		lblNewLabel.setBounds(138, 212, 154, 14);
		frmVeuillezCliquerSur.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Projet_info\\Capture d’écran 2024-06-13 161437.png"));
		btnNewButton.setBounds(27, 71, 89, 36);
		frmVeuillezCliquerSur.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Projet_info\\Capture d’écran .png"));
		btnNewButton_1.setBounds(232, 27, 147, 80);
		frmVeuillezCliquerSur.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Projet_info\\Capture d’écran 2024-06-13 161.png"));
		btnNewButton_2.setBounds(338, 132, 0, 69);
		frmVeuillezCliquerSur.getContentPane().add(btnNewButton_2);
		frmVeuillezCliquerSur.setForeground(Color.BLUE);
		frmVeuillezCliquerSur.setBounds(100, 100, 450, 300);
		frmVeuillezCliquerSur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
