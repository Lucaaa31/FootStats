package unibo.footstats.model;


import unibo.footstats.db.FootStatsDAO;

import java.sql.*;

public class LogIn{
    private String username;
    private String password;
    private FootStatsDAO footStatsDAO;


    public LogIn(final FootStatsDAO footStatsDAO) {
        this.footStatsDAO = footStatsDAO;
    }

    public boolean login(final String username, final String password) throws SQLException {
        return footStatsDAO.login(username, password);
    }

}
