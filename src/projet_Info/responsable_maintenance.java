package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class responsable_maintenance {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    responsable_maintenance window = new responsable_maintenance();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public responsable_maintenance() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("RESPONSABLE MAINTENANCE");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnCreerOperateur = new JButton("Créer un compte opérateur");
        btnCreerOperateur.setBounds(10, 11, 200, 23);
        frame.getContentPane().add(btnCreerOperateur);

        JButton btnModifierOperateur = new JButton("Modifier un compte opérateur");
        btnModifierOperateur.setBounds(10, 45, 200, 23);
        frame.getContentPane().add(btnModifierOperateur);

        JButton btnSupprimerOperateur = new JButton("Supprimer un compte opérateur");
        btnSupprimerOperateur.setBounds(10, 79, 200, 23);
        frame.getContentPane().add(btnSupprimerOperateur);

        JButton btnSaisirDemande = new JButton("Saisir une demande de maintenance");
        btnSaisirDemande.setBounds(10, 113, 200, 23);
        frame.getContentPane().add(btnSaisirDemande);

        JButton btnModifierDemande = new JButton("Modifier une demande de maintenance");
        btnModifierDemande.setBounds(10, 147, 200, 23);
        frame.getContentPane().add(btnModifierDemande);

        JButton btnSupprimerDemande = new JButton("Supprimer une demande de maintenance");
        btnSupprimerDemande.setBounds(10, 181, 200, 23);
        frame.getContentPane().add(btnSupprimerDemande);

        JButton btnSaisirDevis = new JButton("Saisir un devis");
        btnSaisirDevis.setBounds(220, 11, 200, 23);
        frame.getContentPane().add(btnSaisirDevis);

        JButton btnModifierDevis = new JButton("Modifier un devis");
        btnModifierDevis.setBounds(220, 45, 200, 23);
        frame.getContentPane().add(btnModifierDevis);

        JButton btnSupprimerDevis = new JButton("Supprimer un devis");
        btnSupprimerDevis.setBounds(220, 79, 200, 23);
        frame.getContentPane().add(btnSupprimerDevis);

        // Action listeners
        btnCreerOperateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ajout_Operateur ajoutOperateurWindow = new Ajout_Operateur();
                ajoutOperateurWindow.setVisible(true);
            }
        });

        btnModifierOperateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modifier_Operateur modifierOperateurWindow = new Modifier_Operateur();
                modifierOperateurWindow.setVisible(true);
            }
        });

        btnSupprimerOperateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supprimer_Operateur supprimerOperateurWindow = new Supprimer_Operateur();
                supprimerOperateurWindow.setVisible(true);
            }
        });

        btnSaisirDemande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Saisir_Demande saisirDemandeWindow = new Saisir_Demande();
                saisirDemandeWindow.setVisible(true);
            }
        });

        btnModifierDemande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modifier_Demande modifierDemandeWindow = new Modifier_Demande();
                modifierDemandeWindow.setVisible(true);
            }
        });

        btnSupprimerDemande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supprimer_Demande supprimerDemandeWindow = new Supprimer_Demande();
                supprimerDemandeWindow.setVisible(true);
            }
        });

        btnSaisirDevis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Saisir_Devis saisirDevisWindow = new Saisir_Devis();
                saisirDevisWindow.setVisible(true);
            }
        });

        btnModifierDevis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modifier_Devis modifierDevisWindow = new Modifier_Devis();
                modifierDevisWindow.setVisible(true);
            }
        });

        btnSupprimerDevis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supprimer_Devis supprimerDevisWindow = new Supprimer_Devis();
                supprimerDevisWindow.setVisible(true);
            }
        });
    }
}
