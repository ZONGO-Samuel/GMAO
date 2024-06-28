package projet_Info;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class supprime_client {

    private JFrame frame;
    private JTextField textFieldIfu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    supprime_client window = new supprime_client();
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
    public supprime_client() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Supprimer un client");
        frame.setBounds(100, 100, 300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblIfu = new JLabel("IFU du client à supprimer :");
        lblIfu.setBounds(10, 20, 150, 14);
        frame.getContentPane().add(lblIfu);

        textFieldIfu = new JTextField();
        textFieldIfu.setBounds(160, 17, 120, 20);
        frame.getContentPane().add(textFieldIfu);
        textFieldIfu.setColumns(10);

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ifu = textFieldIfu.getText().trim();
                if (!ifu.isEmpty()) {
                    supprimerClient(ifu);
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez saisir l'IFU du client à supprimer.");
                }
            }
        });
        btnSupprimer.setBounds(90, 60, 120, 23);
        frame.getContentPane().add(btnSupprimer);
    }

    /**
     * Méthode pour supprimer un client de la base de données en utilisant son IFU.
     *
     * @param ifu IFU du client à supprimer
     */
    private void supprimerClient(String ifu) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection(ClientDAO.URL, ClientDAO.LOGIN, ClientDAO.PASS);
            ps = con.prepareStatement("DELETE FROM client WHERE ifu = ?");
            ps.setString(1, ifu);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(frame, "Client supprimé avec succès.");
            } else {
                JOptionPane.showMessageDialog(frame, "Aucun client trouvé avec cet IFU.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors de la suppression du client : " + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
