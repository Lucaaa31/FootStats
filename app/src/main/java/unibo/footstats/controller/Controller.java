package unibo.footstats.controller;

import unibo.footstats.db.FootStatsDAO;
import unibo.footstats.model.LogIn;
import unibo.footstats.model.utente.Account;
import unibo.footstats.model.utente.User;
import unibo.footstats.utility.AccountType;
import unibo.footstats.utility.Context;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    private FootStatsDAO footStatsDAO = new FootStatsDAO();
    private LogIn logIn = new LogIn(footStatsDAO);
    private AccountType loggedAccount;
    private User user;
    private Account admin;
    private Context context = Context.LOGIN;



    public void login(final String username, final String password) throws SQLException {
        if (logIn.login(username, password)){
            System.out.println("Login successful!");
            loggedAccount = footStatsDAO.getAccountType(username);
            System.out.println(loggedAccount);
            user = footStatsDAO.getAccount(username);
            System.out.println(footStatsDAO.getAccount(username));
        }
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

    public String[] getCompetitions() {
        return footStatsDAO.getCompetitions();
    }

    public List<String> searchPlayer(final String name, final String nationality) {
        return footStatsDAO.searchPlayer(name, nationality);
    }




}
