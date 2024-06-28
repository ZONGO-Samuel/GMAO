package projet_Info;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class modifie_fenetre {

    private JFrame frame;
    private JComboBox<String> comboBoxClients;
    private JTextField textFieldNom;
    private JTextField textFieldIfu;
    private JTextField textFieldRccm;
    private JTextField textFieldAdresse;
    private JTextField textFieldCodeApe;
    private JLabel lblMessage;

    private ClientDAO clientDAO; // Instance du DAO
    private Client clientToModify; // Client à modifier

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Remplacez ceci par votre logique pour récupérer un client à modifier
                    Client clientToModify = getClientToModify(); // Cette méthode doit être définie pour obtenir le client à modifier

                    // Vérifiez si le client à modifier est non null avant de créer la fenêtre
                    if (clientToModify != null) {
                        modifie_fenetre window = new modifie_fenetre(clientToModify);
                        window.frame.setVisible(true);
                    } else {
                        System.out.println("Aucun client à modifier trouvé.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Méthode factice pour illustrer comment récupérer un client à modifier
    private static Client getClientToModify() {
        // Implémentez cette méthode pour récupérer un client à modifier
        // Exemple de création d'un client factice pour les besoins de démonstration
        Client client = new Client("NomActuel", "IFUActuel", "RCCMActuel", "AdresseActuelle", "CodeApeActuel");
        return client;
    }

    /**
     * Create the application.
     */
    public modifie_fenetre(Client client) {
        this.clientToModify = client;
        clientDAO = new ClientDAO(); // Initialisation du DAO
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Modification de client");
        frame.setBounds(100, 100, 819, 485);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblClient = new JLabel("Client");
        lblClient.setBounds(114, 10, 80, 14);
        frame.getContentPane().add(lblClient);

        // JComboBox pour afficher les noms des clients
        comboBoxClients = new JComboBox<>();
        comboBoxClients.setBounds(232, 7, 150, 20);
        frame.getContentPane().add(comboBoxClients);

        JButton btnLoadClients = new JButton("Charger Clients");
        btnLoadClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Client> clients = clientDAO.getListeClients();
				if (!clients.isEmpty()) {
				    comboBoxClients.removeAllItems(); // Nettoyer les éléments précédents
				    for (Client client : clients) {
				        comboBoxClients.addItem(client.getNom()); // Ajouter les noms des clients à la liste déroulante
				    }
				} else {
				    afficherMessage("Aucun client trouvé dans la base de données.");
				}
            }
        });
        btnLoadClients.setBounds(490, 11, 150, 23);
        frame.getContentPane().add(btnLoadClients);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(114, 100, 80, 14);
        frame.getContentPane().add(lblNom);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(232, 97, 150, 20);
        frame.getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);

        JLabel lblIfu = new JLabel("IFU");
        lblIfu.setBounds(114, 157, 80, 14);
        frame.getContentPane().add(lblIfu);

        textFieldIfu = new JTextField();
        textFieldIfu.setBounds(232, 154, 150, 20);
        frame.getContentPane().add(textFieldIfu);
        textFieldIfu.setColumns(10);

        JLabel lblRccm = new JLabel("RCCM");
        lblRccm.setBounds(114, 198, 80, 14);
        frame.getContentPane().add(lblRccm);

        textFieldRccm = new JTextField();
        textFieldRccm.setBounds(232, 195, 150, 20);
        frame.getContentPane().add(textFieldRccm);
        textFieldRccm.setColumns(10);

        JLabel lblAdresse = new JLabel("Adresse");
        lblAdresse.setBounds(114, 240, 80, 14);
        frame.getContentPane().add(lblAdresse);

        textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(232, 237, 150, 20);
        frame.getContentPane().add(textFieldAdresse);
        textFieldAdresse.setColumns(10);

        JLabel lblCodeApe = new JLabel("Code Ape");
        lblCodeApe.setBounds(114, 277, 80, 14);
        frame.getContentPane().add(lblCodeApe);

        textFieldCodeApe = new JTextField();
        textFieldCodeApe.setBounds(232, 274, 150, 20);
        frame.getContentPane().add(textFieldCodeApe);
        textFieldCodeApe.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = textFieldNom.getText();
                String ifu = textFieldIfu.getText();
                String rccm = textFieldRccm.getText();
                String adresse = textFieldAdresse.getText();
                String codeApe = textFieldCodeApe.getText();

                clientToModify.setNom(nom);
                clientToModify.setIfu(ifu);
                clientToModify.setRccm(rccm);
                clientToModify.setAdresse(adresse);
                clientToModify.setCodeApe(codeApe);

                int retour = clientDAO.modifier(clientToModify);
                if (retour > 0) {
                    afficherMessage("Client modifié avec succès !");
                } else {
                    afficherMessage("Erreur lors de la modification du client.");
                }
            }
        });
        btnSave.setBounds(232, 335, 150, 23);
        frame.getContentPane().add(btnSave);

        lblMessage = new JLabel("");
        lblMessage.setBounds(10, 220, 400, 20);
        frame.getContentPane().add(lblMessage);
    }

    private void afficherMessage(String message) {
        lblMessage.setText(message);
    }

    public JFrame getFrame() {
        return frame;
    }
}
