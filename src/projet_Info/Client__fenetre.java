package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client__fenetre {

    private JFrame frame;
    private JTextField textFieldNom;
    private JTextField textFieldIfu;
    private JTextField textFieldRccm;
    private JTextField textFieldAdresse;
    private JTextField textFieldCodeApe;
    private JLabel lblMessage; // JLabel pour afficher les messages

    private ClientDAO clientDAO; // Instance du DAO

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client__fenetre window = new Client__fenetre();
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
    public Client__fenetre() {
        clientDAO = new ClientDAO(); // Initialisation du DAO
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Saisie de client");
        frame.setBounds(100, 100, 795, 511); // Ajusté la hauteur pour inclure la zone de message
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(195, 74, 80, 14);
        frame.getContentPane().add(lblNom);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(313, 71, 150, 20);
        frame.getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);

        JLabel lblIfu = new JLabel("IFU");
        lblIfu.setBounds(195, 114, 80, 14);
        frame.getContentPane().add(lblIfu);

        textFieldIfu = new JTextField();
        textFieldIfu.setBounds(313, 111, 150, 20);
        frame.getContentPane().add(textFieldIfu);
        textFieldIfu.setColumns(10);

        JLabel lblRccm = new JLabel("RCCM");
        lblRccm.setBounds(195, 158, 80, 14);
        frame.getContentPane().add(lblRccm);

        textFieldRccm = new JTextField();
        textFieldRccm.setBounds(313, 155, 150, 20);
        frame.getContentPane().add(textFieldRccm);
        textFieldRccm.setColumns(10);

        JLabel lblAdresse = new JLabel("Adresse");
        lblAdresse.setBounds(195, 203, 80, 14);
        frame.getContentPane().add(lblAdresse);

        textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(313, 200, 150, 20);
        frame.getContentPane().add(textFieldAdresse);
        textFieldAdresse.setColumns(10);

        JLabel lblCodeApe = new JLabel("Code Ape");
        lblCodeApe.setBounds(195, 244, 80, 14);
        frame.getContentPane().add(lblCodeApe);

        textFieldCodeApe = new JTextField();
        textFieldCodeApe.setBounds(313, 241, 150, 20);
        frame.getContentPane().add(textFieldCodeApe);
        textFieldCodeApe.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action à exécuter lorsque le bouton Save est cliqué
                String nom = textFieldNom.getText();
                String ifu = textFieldIfu.getText();
                String rccm = textFieldRccm.getText();
                String adresse = textFieldAdresse.getText();
                String codeApe = textFieldCodeApe.getText();

                // Création d'un nouvel objet Client
                Client client = new Client(nom, ifu, rccm, adresse, codeApe);

                // Appel de la méthode ajouter du ClientDAO pour enregistrer le client
                int retour = clientDAO.ajouter(client);
                if (retour > 0) {
                    // Afficher un message de succès avec JOptionPane
                    afficherMessage("Client ajouté avec succès !");
                } else {
                    // Afficher un message d'erreur avec JOptionPane si nécessaire
                    afficherMessage("Erreur lors de l'ajout du client.");
                }
            }
        });
        btnSave.setBounds(313, 297, 150, 23);
        frame.getContentPane().add(btnSave);

        // JLabel pour afficher les messages
        lblMessage = new JLabel("");
        lblMessage.setBounds(179, 349, 414, 20);
        frame.getContentPane().add(lblMessage);
    }

    /**
     * Méthode pour afficher un message dans lblMessage.
     *
     * @param message le message à afficher
     */
    private void afficherMessage(String message) {
        lblMessage.setText(message);
    }

    public JFrame getFrame() {
        return frame;
    }
}
