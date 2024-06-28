package projet_Info;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class connect_Interface {

    private JFrame frame;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    
    // DAO pour la gestion de la base de données
    private connectDAO dao = new connectDAO(); // Instance du DAO

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    connect_Interface window = new connect_Interface();
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
    public connect_Interface() {
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

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 414, 239);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(50, 50, 80, 14);
        panel.add(lblLogin);

        textFieldLogin = new JTextField();
        textFieldLogin.setBounds(140, 50, 200, 20);
        panel.add(textFieldLogin);
        textFieldLogin.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 80, 14);
        panel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 100, 200, 20);
        panel.add(passwordField);

        JButton btnLogin = new JButton("Connecter");
        btnLogin.setBounds(150, 150, 100, 30);
        panel.add(btnLogin);
        
        // ActionListener pour le bouton de connexion
        btnLogin.addActionListener(e -> {
            String login = textFieldLogin.getText();
            String password = new String(passwordField.getPassword());
            
            // Vérification des informations de connexion avec le DAO
            String role = dao.verifierLogin(login, password);
            
            if (role != null) {
           
                
                // Redirection vers l'interface appropriée en fonction du rôle de l'utilisateur
                switch (role) {
                    case "ADMINISTRATEUR":
                        // Afficher la fenêtre d'administrateur
                        Administrateur adminWindow = new Administrateur();
                        adminWindow.main(null);
                        frame.setVisible(false); // Masquer la fenêtre de connexion
                        break;
                    case "OPERATEUR":
                    	// Afficher la fenêtre de l'operateur
                        Operateur adminWindow1 = new Operateur();
                        adminWindow1.main(null);
                        frame.setVisible(false); // Masquer la fenêtre de connexion

                        break;
                    case "RESPONSABLE_DE_MAINTENANCE":
                    	// Afficher la fenêtre de l'operateur
                        responsable_maintenance adminWindow2 = new responsable_maintenance();
                        adminWindow2.main(null);
                        frame.setVisible(false); // Masquer la fenêtre de connexion
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Rôle non reconnu !");
                        break;
                }
            } else {
                // Sinon, afficher un message d'erreur
                JOptionPane.showMessageDialog(frame, "Login ou mot de passe incorrect !");
            }
        });
    }
}
