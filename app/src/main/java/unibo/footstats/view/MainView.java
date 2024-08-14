package unibo.footstats.view;

import unibo.footstats.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private Controller controller = new Controller();

    private SignInView signInView = new SignInView(controller);
    private HomePage homePageView = new HomePage();


    public MainView() {
        setTitle("Welcome to FootStats!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(cardLayout);

        final LogInView logInView = new LogInView(controller, e -> {
            try {
                System.out.println(this.getContentPane());
                cardLayout.show(this.getContentPane(), "homePage");
                this.revalidate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        cardLayout.addLayoutComponent(logInView, "login");
        cardLayout.addLayoutComponent(signInView, "signin");
        cardLayout.addLayoutComponent(homePageView, "homePage");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Select an option");
        JMenuItem loginAsAdmin = new JMenuItem("Login as Admin");
        JMenuItem loginAsUser = new JMenuItem("Login as User");
        JMenuItem signInUser = new JMenuItem("Sign In as User");

        menu.add(loginAsAdmin);
        menu.add(loginAsUser);
        menu.add(signInUser);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        this.add(logInView);
        this.add(signInView);

        loginAsAdmin.addActionListener(e -> {
            logInView.setSelectedRole("admin");
            menu.setText("Login as Admin");
            cardLayout.show(this.getContentPane(), "login");
            this.revalidate();
        });

        loginAsUser.addActionListener(e -> {
            cardLayout.show(this.getContentPane(), "login");
            logInView.setSelectedRole("user");
            menu.setText("Login as User");
            this.revalidate();
        });

        signInUser.addActionListener(e -> {
            cardLayout.show(this.getContentPane(), "signin");
            menu.setText("Sign In as User");
            this.revalidate();
        });

        logInView.setVisible(false);
        signInView.setVisible(false);

        setVisible(true);
    }
}
