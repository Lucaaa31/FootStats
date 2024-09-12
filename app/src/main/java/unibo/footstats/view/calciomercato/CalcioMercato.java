package unibo.footstats.view.calciomercato;

import unibo.footstats.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CalcioMercato extends JPanel {

    // Constructor
    public CalcioMercato(final Controller controller) {
        // Setting the layout of the JPanel
        setLayout(new BorderLayout());

        // Creating title label
        JLabel titleLabel = new JLabel("Player Hub", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Sans-Serif", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Creating the "Back" button and making it smaller and square
        JButton backButton = new JButton("Indietro");


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackButtonClick();
            }
        });

        // Add the Back button to the bottom-left of the panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(backButton, BorderLayout.SOUTH); // Placing it at the bottom of the left side
        add(leftPanel, BorderLayout.WEST);

        // Creating the main action buttons with smaller dimensions
        JButton btnMostValuablePlayers = createCustomButton("Most Valuable Players");
        btnMostValuablePlayers.setPreferredSize(new Dimension(150, 50));
        JButton btnMostPaidPlayers = createCustomButton("Most Paid Players");
        btnMostPaidPlayers.setPreferredSize(new Dimension(150, 50));
        JButton btnPlayerAtParam0 = createCustomButton("Player at Param 0");
        btnPlayerAtParam0.setPreferredSize(new Dimension(150, 50));
        JButton btnPlayersWithOneYearLeft = createCustomButton("1 Year Left");
        btnPlayersWithOneYearLeft.setPreferredSize(new Dimension(150, 50));

        // Adding Action Listeners to buttons
        btnMostValuablePlayers.addActionListener(new ButtonActionListener());
        btnMostPaidPlayers.addActionListener(new ButtonActionListener());
        btnPlayerAtParam0.addActionListener(new ButtonActionListener());
        btnPlayersWithOneYearLeft.addActionListener(new ButtonActionListener());

        // Creating a panel to hold the buttons and using a grid layout with 2 rows and 2 columns
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns, with spacing between buttons
        buttonPanel.add(btnMostValuablePlayers);
        buttonPanel.add(btnMostPaidPlayers);
        buttonPanel.add(btnPlayerAtParam0);
        buttonPanel.add(btnPlayersWithOneYearLeft);

        // Adding the buttons panel to the center of the main panel
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Method to create custom buttons with color, font, and border
    private JButton createCustomButton(final String text) {
        JButton button = new JButton(text);

        // Set custom background color
        button.setBackground(Color.GRAY);

        // Set custom border (thicker border)
        button.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

        // Set custom font (Sans-Serif)
        button.setFont(new Font("Sans-Serif", Font.PLAIN, 20));

        // Set text color (optional)
        button.setForeground(Color.BLACK);

        // Set button to opaque and make the border visible
        button.setOpaque(true);
        button.setBorderPainted(true);

        return button;
    }

    // ActionListener for handling button clicks
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String buttonText = sourceButton.getText();

            switch (buttonText) {
                case "Most Valuable Players":
                    visualizeMostValuablePlayers();
                    break;
                case "Most Paid Players":
                    visualizeMostPaidPlayers();
                    break;
                case "Player at Param 0":
                    visualizePlayerAtParameter0();
                    break;
                case "1 Year Left":
                    visualizePlayersWithOneYearLeft();
                    break;
                default:
                    break;
            }
        }
    }

    // Handle Back button action
    private void handleBackButtonClick() {
        JOptionPane.showMessageDialog(this, "Going back...");
        // Add logic for going back (e.g., returning to the previous panel/screen)
    }

    // Methods to handle different visualizations
    private void visualizeMostValuablePlayers() {
        JOptionPane.showMessageDialog(this, "Visualizing the Most Valuable Players...");
        // Add logic to display the most valuable players
    }

    private void visualizeMostPaidPlayers() {
        JOptionPane.showMessageDialog(this, "Visualizing the Most Paid Players...");
        // Add logic to display the most paid players
    }

    private void visualizePlayerAtParameter0() {
        JOptionPane.showMessageDialog(this, "Visualizing the Player at Parameter 0...");
        // Add logic to display the player at parameter 0
    }

    private void visualizePlayersWithOneYearLeft() {
        JOptionPane.showMessageDialog(this, "Visualizing Players with One Year of Contract Left...");
        // Add logic to display players with one year of contract left
    }
}
