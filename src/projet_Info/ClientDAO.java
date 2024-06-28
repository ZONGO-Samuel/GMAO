package projet_Info;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'accès aux données contenues dans la table client
 */
public class ClientDAO {

    /**
     * Paramètres de connexion à la base de données Oracle.
     * URL, LOGIN et PASS sont des constantes.
     * Assurez-vous d'adapter ces valeurs à votre environnement.
     */
    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String LOGIN = "dispositif_sanitaire";
    final static String PASS = "IC2024";

    /**
     * Constructeur de la classe ClientDAO.
     * Charge le pilote JDBC pour Oracle.
     */
    public ClientDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    /**
     * Ajoute un client dans la table client.
     * @param client Le client à ajouter.
     * @return Le nombre de lignes ajoutées dans la table (1 si ajouté avec succès, 0 sinon).
     */
    public int ajouter(Client client) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("INSERT INTO client (nom, ifu, rccm, adresse, codeApe) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, client.getNom());
            ps.setString(2, client.getIfu());
            ps.setString(3, client.getRccm());
            ps.setString(4, client.getAdresse());
            ps.setString(5, client.getCodeApe());

            retour = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fermerRessources(con, ps);
        }
        return retour;
    }

    /**
     * Modifie les informations d'un client dans la table client.
     * @param clientToModify Le client à modifier.
     * @return Le nombre de lignes modifiées dans la table (1 si modifié avec succès, 0 sinon).
     */
    public int modifier(Client clientToModify) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("UPDATE client SET nom=?, rccm=?, adresse=?, codeApe=? WHERE ifu=?");
            ps.setString(1, clientToModify.getNom());
            ps.setString(2, clientToModify.getRccm());
            ps.setString(3, clientToModify.getAdresse());
            ps.setString(4, clientToModify.getCodeApe());
            ps.setString(5, clientToModify.getIfu());

            retour = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fermerRessources(con, ps);
        }
        return retour;
    }

    /**
     * Récupère un client à partir de son IFU.
     * @param ifu L'IFU du client à récupérer.
     * @return Le client trouvé, ou null si aucun client correspondant n'est trouvé.
     */
    public Client getClient(String ifu) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Client client = null;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM client WHERE ifu=?");
            ps.setString(1, ifu);
            rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client(
                        rs.getString("nom"),
                        rs.getString("ifu"),
                        rs.getString("rccm"),
                        rs.getString("adresse"),
                        rs.getString("codeApe")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fermerRessources(con, ps, rs);
        }
        return client;
    }

    /**
     * Récupère la liste de tous les clients dans la table client.
     * @return Une liste contenant tous les clients.
     */
    public List<Client> getListeClients() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Client> clients = new ArrayList<>();

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM client");
            rs = ps.executeQuery();

            while (rs.next()) {
                Client client = new Client(
                        rs.getString("nom"),
                        rs.getString("ifu"),
                        rs.getString("rccm"),
                        rs.getString("adresse"),
                        rs.getString("codeApe")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fermerRessources(con, ps, rs);
        }
        return clients;
    }

    /**
     * Ferme les ressources de connexion à la base de données.
     * @param con La connexion à fermer.
     * @param ps Le PreparedStatement à fermer.
     * @param rs Le ResultSet à fermer.
     */
    private void fermerRessources(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ferme les ressources de connexion à la base de données sans ResultSet.
     * @param con La connexion à fermer.
     * @param ps Le PreparedStatement à fermer.
     */
    private void fermerRessources(Connection con, PreparedStatement ps) {
        fermerRessources(con, ps, null);
    }
}
