package unibo.footstats.model;

import unibo.footstats.db.DatabaseConnection;

import java.sql.*;

public class LogIn{
    private String username;
    private String password;
    private Connection connection;


    public LogIn(final Connection connection) {
        this.connection = connection;
    }

    public void login(String username, String password) throws SQLException {

    }

}
