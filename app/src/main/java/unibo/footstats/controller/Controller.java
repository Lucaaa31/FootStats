package unibo.footstats.controller;

import unibo.footstats.db.DatabaseConnection;
import unibo.footstats.model.LogIn;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private Connection connection;
    private LogIn logIn;

    public Controller() {
        connection = databaseConnection.getConnection();
        logIn = new LogIn(connection);
    }

    public void login(final String username, final String password) throws SQLException {
        logIn.login(username, password);
    }



}
