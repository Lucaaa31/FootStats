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
    private String currentCompetition;




    public void login(final String username, final String password) throws SQLException {
        if (footStatsDAO.login(username, password)){
            System.out.println(username + " " + password);
            loggedAccount = footStatsDAO.getAccountType(username);
            user = footStatsDAO.getAccount(username);
        }
    }

    public void registerUser(final String name, final String surname, final String username, final String password) throws SQLException {
        if(footStatsDAO.registerUser(name, surname, username, password)){
            loggedAccount = AccountType.USER;
            user = footStatsDAO.getAccount(username);
        }
    }

    public String[][] getRanking(final String season) {

        return footStatsDAO.getRanking(currentCompetition, season);
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

    public void submitRequest(final String request, final String requestType) throws SQLException {
        footStatsDAO.submitRequest(user.getUsername(), request, requestType);
    }

    public String[][] getRequestsStatus() {
        return footStatsDAO.getRequestsStatus(user.getUsername());
    }

    public void setCurrentCompetition(String currentCompetition) {
        this.currentCompetition = currentCompetition;
    }

    public void deleteRequest(final String request) {
        footStatsDAO.deleteRequest(request);
    }
}
