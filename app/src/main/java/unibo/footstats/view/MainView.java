package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.AccountType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainView extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private Controller controller = new Controller();

    private SignInView signInView = new SignInView(controller);
    private HomePage homePageView = new HomePage(controller);
    private LogInView logInView = new LogInView(controller);
    private PlayerSearch playerSearchView = new PlayerSearch(controller);


    public MainView() {
        setTitle("Welcome to FootStats!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(cardLayout);

        cardLayout.addLayoutComponent(signInView, "signIn");
        cardLayout.addLayoutComponent(homePageView, "homePage");
        cardLayout.addLayoutComponent(logInView, "logIn");
        cardLayout.addLayoutComponent(playerSearchView, "playerSearch");


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Log In");
        JMenuItem logIn = new JMenuItem("Log In");
        JMenuItem signIn = new JMenuItem("Sign In");

        menu.add(logIn);
        menu.add(signIn);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        this.add(logInView);
        this.add(signInView);
        this.add(homePageView);
        this.add(playerSearchView);


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

        logInView.addComponentListener(new ComponentAdapter() {
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
                    case TEAM_SEARCH:
                        break;
                    case TOURNAMENT_SEARCH:
                        break;
                    case TRANSFER_MARKET:
                        break;
                    case LOGIN:
                        menu.setVisible(true);
                        cardLayout.show(MainView.this.getContentPane(), "logIn");
                        MainView.this.setSize(600, 400);
                        MainView.this.revalidate();
                        break;
                }

            }
        });

        playerSearchView.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                cardLayout.show(MainView.this.getContentPane(), "homePage");
                MainView.this.revalidate();
            }
        });



        logInView.setVisible(false);
        signInView.setVisible(false);

        setVisible(true);
    }
}
