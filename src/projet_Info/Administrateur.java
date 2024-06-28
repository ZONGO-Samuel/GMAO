package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
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
        frmAdministrateur.setBounds(100, 100, 801, 474);
        frmAdministrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdministrateur.getContentPane().setLayout(null);
        
        JButton btnSaisirUnClient = new JButton("Saisir un client");
        btnSaisirUnClient.setBounds(262, 87, 185, 23);
        frmAdministrateur.getContentPane().add(btnSaisirUnClient);
        
        JButton btnSupprimerUnClient = new JButton("Supprimer un client");
        btnSupprimerUnClient.setBounds(262, 174, 185, 23);
        frmAdministrateur.getContentPane().add(btnSupprimerUnClient);
        
        // Bouton "Modifier un client"
        JButton btnModifierUnClient = new JButton("Modifier un client");
        btnModifierUnClient.setBounds(262, 254, 185, 23);
        frmAdministrateur.getContentPane().add(btnModifierUnClient);
        
        // Action listener for "Saisir un client" button
        btnSaisirUnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre de saisie de client
                Client__fenetre clientWindow = new Client__fenetre();
                clientWindow.main(null); // Lancer la fenêtre
            }
        });
        
        
        btnModifierUnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre de modification de client
                modifie_fenetre modifieClientWindow = new modifie_fenetre(null);
                modifieClientWindow.main(null); // Lancer la fenêtre
            }
        });
        
        // Action listener for "Supprimer un client" button
        btnSupprimerUnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre de suppression de client
                supprime_client supprimeClientWindow = new supprime_client();
                supprimeClientWindow.main(null); // Lancer la fenêtre
            }
        });
    }
}
