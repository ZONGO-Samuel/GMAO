package projet_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectDAO {

    // Paramètres de connexion à la base de données Oracle
    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // URL de connexion Oracle
    final static String LOGIN = "dispositif_sanitaire"; // Nom d'utilisateur Oracle
    final static String PASS = "IC2024"; // Mot de passe Oracle

    /**
     * Vérifie les informations de connexion pour les utilisateurs et retourne leur rôle.
     * @param login Login de l'utilisateur
     * @param password Mot de passe de l'utilisateur
     * @return Le rôle de l'utilisateur si les informations sont valides, null sinon
     */
    public String verifierLogin(String login, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String role = null;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);

            // Vérifier dans la table administrateur
            ps = con.prepareStatement("SELECT * FROM administrateur WHERE login = ? AND password = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                role = "ADMINISTRATEUR";
            } else {
                // Vérifier dans la table operateur
                ps = con.prepareStatement("SELECT * FROM operateur WHERE login = ? AND password = ?");
                ps.setString(1, login);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    role = "OPERATEUR";
                } else {
                    // Vérifier dans la table responsable_maitenance
                    ps = con.prepareStatement("SELECT * FROM responsable_maitenance WHERE login = ? AND password = ?");
                    ps.setString(1, login);
                    ps.setString(2, password);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        role = "RESPONSABLE_DE_MAINTENANCE";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return role;
    }

    /**
     * Ferme la connexion, la déclaration PreparedStatement et le ResultSet.
     * @param con Connexion à fermer
     * @param ps PreparedStatement à fermer
     * @param rs ResultSet à fermer
     */
    private void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
