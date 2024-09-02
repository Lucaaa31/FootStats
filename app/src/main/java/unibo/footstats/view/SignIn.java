package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SignIn extends JPanel {
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;

    public SignIn(final Controller controller) {
        JLabel imageLabel = new JLabel();
        ImageIcon logoImage = new ImageIcon(ClassLoader.getSystemResource("images/logo/logo.png"));
        logoImage = new ImageIcon(logoImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        imageLabel.setIcon(logoImage);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(imageLabel, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel(new GridLayout(5, 1, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Surname:");
        surnameField = new JTextField();
        JLabel userLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        signInButton = new JButton("Sign In");

        loginPanel.add(nameLabel);
        loginPanel.add(nameField);
        loginPanel.add(surnameLabel);
        loginPanel.add(surnameField);
        loginPanel.add(userLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passLabel);
        loginPanel.add(passwordField);
        loginPanel.add(signInButton);


        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(loginPanel);

        this.add(centerPanel, BorderLayout.CENTER);

        signInButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                controller.registerUser(name, surname, username, password);
            } catch (Exception ignored) {
            }
            if (controller.getLoggedAccount() != null) {
                JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo!");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "L'username che hai selezionato esiste gia'", "Errore", JOptionPane.ERROR_MESSAGE);
            }


            nameField.setText("");
            surnameField.setText("");
            usernameField.setText("");
            passwordField.setText("");
        });


        setVisible(true);
    }
}
