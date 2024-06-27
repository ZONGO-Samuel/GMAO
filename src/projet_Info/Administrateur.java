package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrateur {

    private JFrame frmAdministrateur;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Administrateur window = new Administrateur();
                    window.frmAdministrateur.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Administrateur() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdministrateur = new JFrame();
        frmAdministrateur.setTitle("ADMINISTRATEUR");
        frmAdministrateur.setBounds(100, 100, 390, 300);
        frmAdministrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdministrateur.getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("saisir un client");
        btnNewButton.setBounds(10, 11, 185, 23);
        frmAdministrateur.getContentPane().add(btnNewButton);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(194, 11, 30, 22);
        frmAdministrateur.getContentPane().add(comboBox);
        
        JButton btnNewButton_1 = new JButton("supprimer un  client");
        btnNewButton_1.setBounds(10, 58, 185, 23);
        frmAdministrateur.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("créer un devis");
        btnNewButton_2.setBounds(10, 105, 185, 23);
        frmAdministrateur.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("cloturer un dossier");
        btnNewButton_3.setBounds(10, 155, 185, 23);
        frmAdministrateur.getContentPane().add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("consulter suivi reglement");
        btnNewButton_4.setBounds(10, 199, 185, 23);
        frmAdministrateur.getContentPane().add(btnNewButton_4);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(194, 58, 30, 22);
        frmAdministrateur.getContentPane().add(comboBox_1);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBounds(194, 105, 30, 22);
        frmAdministrateur.getContentPane().add(comboBox_2);
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setBounds(194, 155, 30, 22);
        frmAdministrateur.getContentPane().add(comboBox_3);
        
        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setBounds(194, 199, 30, 22);
        frmAdministrateur.getContentPane().add(comboBox_4);
        
        // Action listener for "saisir un client" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre de saisie de client
                Client__fenetre clientWindow = new Client__fenetre();
                clientWindow.main(null); // Lancer la fenêtre
            }
        });
    }
}
