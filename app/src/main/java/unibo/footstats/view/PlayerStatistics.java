package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.model.statistiche.PlayerStats;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class PlayerStatistics extends JPanel {
    private final Controller controller;
    private JComboBox<String> seasonComboBox;
    private JComboBox<String> competitionComboBox;
    private JEditorPane statisticsPane; // Changed to JEditorPane
    private JButton backButton;

    public PlayerStatistics(final Controller controller) {
        this.controller = controller;
        initializeComponents();
        setLayout(new BorderLayout());

        add(createFilterPanel(), BorderLayout.NORTH);
        add(new JScrollPane(statisticsPane), BorderLayout.CENTER); // Updated to use JEditorPane
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private void initializeComponents() {
        seasonComboBox = new JComboBox<>(getSeasons());
        competitionComboBox = new JComboBox<>(getCompetitions());
        statisticsPane = new JEditorPane(); // Initialize JEditorPane
        statisticsPane.setContentType("text/html"); // Set content type to HTML
        statisticsPane.setEditable(false); // Make it non-editable
        backButton = new JButton("Back");

        seasonComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStatistics();
            }
        });

        competitionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStatistics();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setContext(Context.HOME_PAGE);
                PlayerStatistics.super.setVisible(false);
            }
        });
    }

    private JPanel createFilterPanel() {
        JPanel filterPanel = new JPanel(new GridLayout(2, 2));
        filterPanel.add(new JLabel("Select Season:"));
        filterPanel.add(seasonComboBox);
        filterPanel.add(new JLabel("Select Competition:"));
        filterPanel.add(competitionComboBox);
        return filterPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        return buttonPanel;
    }

    private String[] getSeasons() {
        List<String> seasons = controller.getSeasons();
        return seasons.toArray(new String[0]);
    }

    private String[] getCompetitions() {
        List<String> competitions = controller.getCompetitions();
        return competitions.toArray(new String[0]);
    }

    private void updateStatistics() {
        String selectedSeason = (String) seasonComboBox.getSelectedItem();
        String selectedCompetition = (String) competitionComboBox.getSelectedItem();

        PlayerStats playerStats = controller.getPlayerStats(
                Objects.equals(selectedSeason, "Tutte le stagioni") ? null : selectedSeason,
                Objects.equals(selectedCompetition, "Tutte le competizioni") ? null : selectedCompetition);

        if (playerStats == null) {
            statisticsPane.setText("<html><body>Nessun risultato trovato, controlla i filtri selezionati.</body></html>");
        } else {
            // Formatting the text using HTML for better presentation
            String statsHtml = "<html><body style='font-family:sans-serif; padding:10px;'>" + "<h2>Statistiche del giocatore</h2>" +
                    "<table style='width:100%;' border='3' cellpadding='5' cellspacing='0'>" +
                    "<tr><td><strong>Nome:</strong></td><td>" + playerStats.name() + "</td></tr>" +
                    "<tr><td><strong>Cognome:</strong></td><td>" + playerStats.lastName() + "</td></tr>" +
                    "<tr><td><strong>Ruolo:</strong></td><td>" + playerStats.ruolo() + "</td></tr>" +
                    "<tr><td><strong>Goal:</strong></td><td>" + playerStats.goal() + "</td></tr>" +
                    "<tr><td><strong>Assist:</strong></td><td>" + playerStats.assist() + "</td></tr>" +
                    "<tr><td><strong>Cartellini:</strong></td><td>" + playerStats.cartellini() + "</td></tr>" +
                    "<tr><td><strong>Valore di mercato:</strong></td><td>" + playerStats.valoreDiMercato() + "</td></tr>" +
                    "<tr><td><strong>Presenze:</strong></td><td>" + playerStats.presenze() + "</td></tr>" +
                    "<tr><td><strong>Numero maglia:</strong></td><td>" + playerStats.numeroMaglia() + "</td></tr>" +
                    "</table>" +
                    "</body></html>";

            statisticsPane.setText(statsHtml);
        }
    }
}