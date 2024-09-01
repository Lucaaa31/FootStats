package unibo.footstats.controller;

import unibo.footstats.db.FootStatsDAO;
import unibo.footstats.model.statistiche.PlayerStats;
import unibo.footstats.model.utente.Account;
import unibo.footstats.model.utente.User;
import unibo.footstats.utility.AccountType;
import unibo.footstats.utility.Context;
import unibo.footstats.utility.PlayerResult;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    private FootStatsDAO footStatsDAO = new FootStatsDAO();
    private AccountType loggedAccount;
    private User user;
    private Account admin;
    private Context context = Context.LOGIN;
    private String currentCF;



    public void login(final String username, final String password) throws SQLException {
        if (footStatsDAO.login(username, password)){
            System.out.println(username + " " + password);
            loggedAccount = footStatsDAO.getAccountType(username);
            user = footStatsDAO.getAccount(username);
        }
    }

    public void logout() {
        loggedAccount = null;
        user = null;
        context = Context.LOGIN;
    }

    public AccountType getLoggedAccount() {
        return loggedAccount;
    }

    public List<String> getCredentials() {
        return user.getCredentials();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(final Context context) {
        this.context = context;
    }

    public List<String> getCompetitions() {
        return footStatsDAO.getCompetitions();
    }

    public List<PlayerResult> searchPlayer(final String name) {
        return footStatsDAO.searchPlayer(name);
    }


    public void setPlayer(final String CF) {
        this.currentCF = CF;
    }

    public List<String> getSeasons() {
        return footStatsDAO.getSeasons();
    }

    public PlayerStats getPlayerStats(final String season, final String competition) {
        return footStatsDAO.getStatistics(currentCF, season, competition);
    }



}
