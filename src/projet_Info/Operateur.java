package projet_Info;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Operateur {

	private JFrame frmOperateur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operateur window = new Operateur();
					window.frmOperateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Operateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOperateur = new JFrame();
		frmOperateur.setTitle("OPERATEUR");
		frmOperateur.setBounds(100, 100, 345, 300);
		frmOperateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOperateur.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"liste des maintenances"}));
		comboBox.setBounds(33, 11, 224, 33);
		frmOperateur.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Liste des prestations"}));
		comboBox_1.setBounds(33, 55, 224, 33);
		frmOperateur.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Modifier le devis"}));
		comboBox_2.setBounds(33, 99, 224, 33);
		frmOperateur.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Modifier liste des maintenances"}));
		comboBox_3.setBounds(33, 143, 224, 33);
		frmOperateur.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Rapport d'activité pour le client"}));
		comboBox_4.setBounds(33, 189, 224, 33);
		frmOperateur.getContentPane().add(comboBox_4);
	}
}
