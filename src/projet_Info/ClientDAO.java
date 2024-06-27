package projet_Info;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'accès aux données contenues dans la table client
 * 
 * @version 1.2
 */
public class ClientDAO {

    /**
     * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
     * sont des constantes
     */
    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    // final static String URL = "jdbc:mysql://localhost/stock";

    final static String LOGIN = "dispositif_sanitaire";  // exemple BDD1
    final static String PASS = "IC2024";   // exemple BDD1

    /**
     * Constructeur de la classe
     */
    public ClientDAO() {
        // chargement du pilote de bases de données
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    /**
     * Permet d'ajouter un client dans la table client
     * Le mode est auto-commit par défaut : chaque insertion est validée
     * 
     * @param client le client à ajouter
     * @return retourne le nombre de lignes ajoutées dans la table
     */
    public int ajouter(Client client) {
        Connection con = null;
        PreparedStatement ps = null;
        int retour = 0;

        // connexion à la base de données
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("INSERT INTO client (nom, ifu, rccm, adresse, codeApe) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, client.getNom());
            ps.setString(2, client.getIfu());
            ps.setString(3, client.getRccm());
            ps.setString(4, client.getAdresse());
            ps.setString(5, client.getCodeApe());

            retour = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception ignore) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (Exception ignore) {
            }
        }
        return retour;
    }

    /**
     * Permet de récupérer un client à partir de son IFU
     * 
     * @param ifu l'IFU du client à récupérer
     * @return le client trouvé; null si aucun client ne correspond à cet IFU
     */
    public Client getClient(String ifu) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Client retour = null;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM client WHERE ifu = ?");
            ps.setString(1, ifu);

            rs = ps.executeQuery();
            if (rs.next()) {
                retour = new Client(
                    rs.getString("nom"),
                    rs.getString("ifu"),
                    rs.getString("rccm"),
                    rs.getString("adresse"),
                    rs.getString("codeApe")
                );
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception ignore) {
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception ignore) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (Exception ignore) {
            }
        }
        return retour;
    }

    /**
     * Permet de récupérer tous les clients stockés dans la table clients
     * 
     * @return une ArrayList de Clients
     */
    public List<Client> getListeClients() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Client> retour = new ArrayList<Client>();

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM client");

            rs = ps.executeQuery();
            while (rs.next()) {
                retour.add(new Client(
                    rs.getString("nom"),
                    rs.getString("ifu"),
                    rs.getString("rccm"),
                    rs.getString("adresse"),
                    rs.getString("codeApe")
                ));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception ignore) {
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception ignore) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (Exception ignore) {
            }
        }
        return retour;
    }

    // main permettant de tester la classe
    public static void main(String[] args) throws SQLException {
        ClientDAO clientDAO = new ClientDAO();
        
        // test de la méthode ajouter
        Client c1 = new Client("Nom1", "IFU1", "RCCM1", "Adresse1", "CodeAPE1");
        int retour = clientDAO.ajouter(c1);
        System.out.println(retour + " lignes ajoutées");

        // test de la méthode getClient
        Client c2 = clientDAO.getClient("IFU1");
        System.out.println(c2);

        // test de la méthode getListeClients
        List<Client> liste = clientDAO.getListeClients();
        for (Client client : liste) {
            System.out.println(client.toString());
        }
    }
}
