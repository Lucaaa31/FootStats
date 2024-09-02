package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainView extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private Controller controller = new Controller();

    private SignIn signIn = new SignIn(controller);
    private HomePage homePageView = new HomePage(controller);
    private LogIn logIn = new LogIn(controller);
    private PlayerSearch playerSearchView = new PlayerSearch(controller);
    private CompetitionSelection competitionSelection = new CompetitionSelection(controller);
    private PlayerStatistics playerStatistics = new PlayerStatistics(controller);
    private Request request = new Request(controller);


    public MainView() {
        setTitle("Welcome to FootStats!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(cardLayout);

        cardLayout.addLayoutComponent(signIn, "signIn");
        cardLayout.addLayoutComponent(homePageView, "homePage");
        cardLayout.addLayoutComponent(logIn, "logIn");
        cardLayout.addLayoutComponent(playerSearchView, "playerSearch");
        cardLayout.addLayoutComponent(competitionSelection, "competition");
        cardLayout.addLayoutComponent(playerStatistics, "playerStatistics");
        cardLayout.addLayoutComponent(request, "request");


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Log In");
        JMenuItem logIn = new JMenuItem("Log In");
        JMenuItem signIn = new JMenuItem("Sign In");

        menu.add(logIn);
        menu.add(signIn);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        this.add(this.logIn);
        this.add(this.signIn);
        this.add(homePageView);
        this.add(playerSearchView);
        this.add(competitionSelection);
        this.add(playerStatistics);
        this.add(request);


        logIn.addActionListener(e -> {
            cardLayout.show(this.getContentPane(), "logIn");
            menu.setText("Log In");
            this.revalidate();
        });

        signIn.addActionListener(e -> {
            cardLayout.show(this.getContentPane(), "signIn");
            menu.setText("Sign In");
            this.revalidate();
        });

        this.logIn.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                menu.setVisible(false);
                if (controller.getLoggedAccount() != null) {
                    cardLayout.show(MainView.this.getContentPane(), "homePage");
                    MainView.this.setSize(800, 600);
                    MainView.this.revalidate();
                }
            }
        });

        homePageView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                System.out.println(controller.getContext());
                switch (controller.getContext()) {
                    case PLAYER_SEARCH:
                        cardLayout.show(MainView.this.getContentPane(), "playerSearch");
                        MainView.this.revalidate();
                        break;
                    case PLAYER_STATISTICS:
                        cardLayout.show(MainView.this.getContentPane(), "playerStatistics");
                        break;
                    case TEAM_SEARCH:
                        break;
                    case TOURNAMENT_SEARCH:
                        cardLayout.show(MainView.this.getContentPane(), "competition");
                        MainView.this.revalidate();
                        break;
                    case TRANSFER_MARKET:
                        break;
                    case REQUEST:
                        cardLayout.show(MainView.this.getContentPane(), "request");
                        MainView.this.revalidate();
                        break;
                    case LOGIN:
                        menu.setVisible(true);
                        cardLayout.show(MainView.this.getContentPane(), "logIn");
                        controller.logout();
                        MainView.this.setSize(600, 400);
                        MainView.this.revalidate();
                        break;
                }

            }
        });

        playerSearchView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                if (controller.getContext() == Context.PLAYER_STATISTICS) {
                    cardLayout.show(MainView.this.getContentPane(), "playerStatistics");
                    MainView.this.revalidate();
                }else{
                    cardLayout.show(MainView.this.getContentPane(), "homePage");
                }
                MainView.this.revalidate();
            }
        });

        playerStatistics.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                cardLayout.show(MainView.this.getContentPane(), "homePage");
                MainView.this.revalidate();
            }
        });

        competitionSelection.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                cardLayout.show(MainView.this.getContentPane(), "homePage");
                MainView.this.revalidate();
            }
        });

        request.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                cardLayout.show(MainView.this.getContentPane(), "homePage");
                MainView.this.revalidate();
            }
        });



        this.logIn.setVisible(false);
        this.signIn.setVisible(false);

        setVisible(true);
    }
}
