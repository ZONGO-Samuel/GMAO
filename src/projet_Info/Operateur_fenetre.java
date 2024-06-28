package projet_Info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Operateur_fenetre {

	private JFrame frmOperateur_fenetre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operateur_fenetre window = new Operateur_fenetre();
					window.frmOperateur_fenetre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Operateur_fenetre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOperateur_fenetre = new JFrame();
		frmOperateur_fenetre.setTitle("OPERATEUR");
		frmOperateur_fenetre.setBounds(100, 100, 345, 300);
		frmOperateur_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOperateur_fenetre.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"liste des maintenances"}));
		comboBox.setBounds(33, 11, 224, 33);
		frmOperateur_fenetre.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Liste des prestations"}));
		comboBox_1.setBounds(33, 55, 224, 33);
		frmOperateur_fenetre.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Modifier le devis"}));
		comboBox_2.setBounds(33, 99, 224, 33);
		frmOperateur_fenetre.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Modifier liste des maintenances"}));
		comboBox_3.setBounds(33, 143, 224, 33);
		frmOperateur_fenetre.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Rapport d'activité pour le client"}));
		comboBox_4.setBounds(33, 189, 224, 33);
		frmOperateur_fenetre.getContentPane().add(comboBox_4);
	}
}
