package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajout_Operateur {

    private JFrame frame;
    private JTextField textFieldNom;
    private JTextField textFieldLogin;
    private JTextField textFieldEmail;
    private JTextField textFieldPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ajout_Operateur window = new Ajout_Operateur();
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
    public Ajout_Operateur() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 801, 469);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNom = new JLabel("Nom:");
        lblNom.setBounds(111, 11, 86, 14);
        frame.getContentPane().add(lblNom);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(220, 8, 318, 20);
        frame.getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(111, 55, 86, 14);
        frame.getContentPane().add(lblLogin);

        textFieldLogin = new JTextField();
        textFieldLogin.setBounds(220, 52, 318, 20);
        frame.getContentPane().add(textFieldLogin);
        textFieldLogin.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(111, 116, 86, 14);
        frame.getContentPane().add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(220, 113, 318, 20);
        frame.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(111, 180, 86, 14);
        frame.getContentPane().add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(220, 177, 318, 20);
        frame.getContentPane().add(textFieldPassword);
        textFieldPassword.setColumns(10);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = textFieldNom.getText();
                String login = textFieldLogin.getText();
                String email = textFieldEmail.getText();
                String password = textFieldPassword.getText();

                Operateur operateur = new Operateur(nom, login, email, password);
                OperateurDAO operateurDAO = new OperateurDAO();
                
                try {
                    operateurDAO.ajouter(operateur);
                    // Affiche un message de confirmation ou effectue une action supplémentaire si nécessaire
                    System.out.println("Opérateur ajouté avec succès !");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // Gère les erreurs d'ajout d'opérateur ici
                    System.err.println("Erreur lors de l'ajout de l'opérateur : " + ex.getMessage());
                }
            }
        });
        btnAjouter.setBounds(335, 227, 89, 23);
        frame.getContentPane().add(btnAjouter);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
