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
            StringBuilder statsHtml = new StringBuilder("<html><body style='font-family:sans-serif; padding:10px;'>");
            statsHtml.append("<h2>Statistiche del giocatore</h2>");
            statsHtml.append("<table style='width:100%;' border='1' cellpadding='5' cellspacing='0'>");
            statsHtml.append("<tr><td><strong>Nome:</strong></td><td>").append(playerStats.name()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Cognome:</strong></td><td>").append(playerStats.lastName()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Ruolo:</strong></td><td>").append(playerStats.ruolo()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Goal:</strong></td><td>").append(playerStats.goal()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Assist:</strong></td><td>").append(playerStats.assist()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Cartellini:</strong></td><td>").append(playerStats.cartellini()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Valore di mercato:</strong></td><td>").append(playerStats.valoreDiMercato()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Presenze:</strong></td><td>").append(playerStats.presenze()).append("</td></tr>");
            statsHtml.append("<tr><td><strong>Numero maglia:</strong></td><td>").append(playerStats.numeroMaglia()).append("</td></tr>");
            statsHtml.append("</table>");
            statsHtml.append("</body></html>");

            statisticsPane.setText(statsHtml.toString());
        }
    }
}
