package unibo.footstats.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/FootStats";
                String user = "root";
                String password = "12345";
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connessione stabilita con successo.");
            } catch (SQLException e) {
                System.out.println("Errore durante la connessione: " + e.getMessage());
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connessione chiusa con successo.");
            } catch (SQLException e) {
                System.out.println("Errore durante la chiusura della connessione: " + e.getMessage());
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}

