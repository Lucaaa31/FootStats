package unibo.footstats.view;

import unibo.footstats.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

public class LogInView extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private String selectedRole = "user";


    public LogInView(final Controller controller, final ActionListener actionListener) {
        JLabel imageLabel = new JLabel();
        ImageIcon logoImage = new ImageIcon(ClassLoader.getSystemResource("images/logo/logo.png"));
        logoImage = new ImageIcon(logoImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        imageLabel.setIcon(logoImage);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(imageLabel, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");

        loginPanel.add(userLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(loginPanel);

        this.add(centerPanel, BorderLayout.CENTER);


        loginButton.addActionListener(actionListener);

        setVisible(true);
    }

    public void setSelectedRole(String selectedRole) {
        this.selectedRole = selectedRole;
    }

}
