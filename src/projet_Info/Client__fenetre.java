package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client__fenetre {

    private JFrame frame;
    private JTextField textFieldNom;
    private JTextField textFieldIfu;
    private JTextField textFieldRccm;
    private JTextField textFieldAdresse;
    private JTextField textFieldCodeApe;

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
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(10, 10, 80, 14);
        frame.getContentPane().add(lblNom);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(100, 7, 150, 20);
        frame.getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);

        JLabel lblIfu = new JLabel("IFU");
        lblIfu.setBounds(10, 40, 80, 14);
        frame.getContentPane().add(lblIfu);

        textFieldIfu = new JTextField();
        textFieldIfu.setBounds(100, 37, 150, 20);
        frame.getContentPane().add(textFieldIfu);
        textFieldIfu.setColumns(10);

        JLabel lblRccm = new JLabel("RCCM");
        lblRccm.setBounds(10, 70, 80, 14);
        frame.getContentPane().add(lblRccm);

        textFieldRccm = new JTextField();
        textFieldRccm.setBounds(100, 67, 150, 20);
        frame.getContentPane().add(textFieldRccm);
        textFieldRccm.setColumns(10);

        JLabel lblAdresse = new JLabel("Adresse");
        lblAdresse.setBounds(10, 100, 80, 14);
        frame.getContentPane().add(lblAdresse);

        textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(100, 97, 150, 20);
        frame.getContentPane().add(textFieldAdresse);
        textFieldAdresse.setColumns(10);

        JLabel lblCodeApe = new JLabel("Code Ape");
        lblCodeApe.setBounds(10, 130, 80, 14);
        frame.getContentPane().add(lblCodeApe);

        textFieldCodeApe = new JTextField();
        textFieldCodeApe.setBounds(100, 127, 150, 20);
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
                    System.out.println("Client ajouté avec succès !");
                    // Vous pouvez ajouter ici une boîte de dialogue de confirmation
                } else {
                    System.out.println("Erreur lors de l'ajout du client.");
                    // Vous pouvez ajouter ici une boîte de dialogue d'erreur
                }
            }
        });
        btnSave.setBounds(100, 160, 150, 23);
        frame.getContentPane().add(btnSave);
    } 
}
