package projet_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperateurDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
    private String jdbcUsername = "your_username";
    private String jdbcPassword = "your_password";
    private Connection jdbcConnection;

    public OperateurDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertOperateur(Operateur operateur) throws SQLException {
        String sql = "INSERT INTO operateur (id_operateur, nom, login, email, password) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, operateur.getIdOperateur());
        statement.setString(2, operateur.getNom());
        statement.setString(3, operateur.getLogin());
        statement.setString(4, operateur.getEmail());
        statement.setString(5, operateur.getPassword());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Operateur> listAllOperateurs() throws SQLException {
        List<Operateur> listOperateur = new ArrayList<>();

        String sql = "SELECT * FROM operateur";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id_operateur");
            String nom = resultSet.getString("nom");
            String login = resultSet.getString("login");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            Operateur operateur = new Operateur(id, nom, login, email, password);
            listOperateur.add(operateur);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOperateur;
    }

    public boolean deleteOperateur(Operateur operateur) throws SQLException {
        String sql = "DELETE FROM operateur where id_operateur = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, operateur.getIdOperateur());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateOperateur(Operateur operateur) throws SQLException {
        String sql = "UPDATE operateur SET nom = ?, login = ?, email = ?, password = ?";
        sql += " WHERE id_operateur = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, operateur.getNom());
        statement.setString(2, operateur.getLogin());
        statement.setString(3, operateur.getEmail());
        statement.setString(4, operateur.getPassword());
        statement.setInt(5, operateur.getIdOperateur());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
    

    public Operateur getOperateur(int id) throws SQLException {
        Operateur operateur = null;
        String sql = "SELECT * FROM operateur WHERE id_operateur = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nom = resultSet.getString("nom");
            String login = resultSet.getString("login");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            operateur = new Operateur(nom, login, email, password);
        }

        resultSet.close();
        statement.close();

        return operateur;
    }

	public void ajouter(Operateur operateur) {
		// TODO Auto-generated method stub
		
	}
}
