package unibo.footstats.view.competitions;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CompetitionSelection extends JPanel {
    private JButton backButton;
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private NationalSelection nationalSelection;
    private LeagueSelection leagueSelection;
    private RankingCompetition rankingCompetition;
    private String currentSelection = "Nazionali";

    public CompetitionSelection(final Controller controller) {
        rankingCompetition = new RankingCompetition(controller);
        nationalSelection = new NationalSelection(controller);
        leagueSelection = new LeagueSelection(controller);
        setLayout(new BorderLayout());



        JButton selectButton = new JButton(currentSelection);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Scorri tra le tipologie di competizione utilizzando questo tasto -->"));
        topPanel.add(selectButton, BorderLayout.EAST); // Position the button at the top right

        add(topPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(leagueSelection, "Club");
        cardPanel.add(nationalSelection, "Nazionali");
        cardPanel.add(rankingCompetition, "classifica");

        add(cardPanel, BorderLayout.CENTER);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentSelection.equals("Nazionali")) {
                    currentSelection = "Club";
                    selectButton.setText(currentSelection);
                    cardLayout.show(cardPanel, "Nazionali");
                } else {
                    currentSelection = "Nazionali";
                    selectButton.setText(currentSelection);
                    cardLayout.show(cardPanel, "Club");
                }
            }
        });

        leagueSelection.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                if (controller.getContext() == Context.RANKING) {
                    topPanel.setVisible(false);
                    cardLayout.show(cardPanel, "classifica");
                }
            }
        });

        nationalSelection.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                if (controller.getContext() == Context.RANKING) {
                    topPanel.setVisible(false);
                    cardLayout.show(cardPanel, "classifica");
                }
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                topPanel.setVisible(true);
                cardLayout.show(cardPanel, "Club");
            }
        });

        backButton = new JButton("Indietro");
        backButton.addActionListener(e -> {
            controller.setContext(Context.HOME_PAGE);
            CompetitionSelection.super.setVisible(false);
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(backButton, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}