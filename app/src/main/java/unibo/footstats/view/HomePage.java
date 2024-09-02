package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private final JButton accountButton;
    private final JList<String> actionList;
    private final JLabel welcomeLabel;
    private final JLabel descriptionLabel;

    public HomePage(final Controller controller) {
        // Imposta il layout principale del pannello
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 245)); // Colore di sfondo grigio chiaro per il pannello

        // Creazione del pannello superiore con etichetta di benvenuto e pulsante account
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(getBackground()); // Imposta lo stesso colore di sfondo del pannello principale

        // Creazione e stile dell'etichetta di benvenuto
        welcomeLabel = new JLabel("Benvenuto su FootStats!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(34, 34, 34)); // Colore del testo grigio scuro
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Aggiunge padding verticale
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Creazione e stile del pulsante account
        accountButton = new JButton("Account");
        accountButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        accountButton.setBackground(new Color(14, 85, 143)); // Colore blu acciaio per il pulsante
        accountButton.setForeground(Color.WHITE);
        accountButton.setFocusPainted(false);
        accountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        accountButton.setPreferredSize(new Dimension(100, 40)); // Dimensiona il pulsante in modo appropriato
        topPanel.add(accountButton, BorderLayout.EAST);

        // Aggiunta del pannello superiore al pannello principale
        add(topPanel, BorderLayout.NORTH);

        // Creazione del pannello centrale per descrizione e azioni
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(getBackground());

        // Creazione e stile dell'etichetta di descrizione
        descriptionLabel = new JLabel("<html>Al momento ti trovi nella sezione di navigazione di FootStats!<br>" +
                "Per esplorare le varie funzionalita' dell'applicazione " +
                "seleziona un'opzione dall'elenco qui sotto per iniziare:</html>");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        descriptionLabel.setForeground(new Color(64, 64, 64)); // Colore del testo grigio scuro per contrasto
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding intorno al testo
        centerPanel.add(descriptionLabel, BorderLayout.NORTH);

        // Creazione e popolazione della lista delle azioni
        String[] listData = {
                "Cerca Giocatore",
                "Cerca Squadra",
                "Cerca Campionato/Torneo",
                "Calciomercato",
                "Invia una Richiesta",
                "",
                "",
                "",
                "Logout"
        };
        actionList = new JList<>(listData);
        actionList.setFont(new Font("SansSerif", Font.PLAIN, 18));
        actionList.setFixedCellHeight(40);
        actionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        actionList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionList.setSelectionBackground(new Color(48, 101, 202)); // Colore blu fiordaliso quando selezionato
        actionList.setSelectionForeground(Color.WHITE);

        // Avvolgi la lista in un JScrollPane
        JScrollPane scrollPane = new JScrollPane(actionList);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Aggiunta dello JScrollPane al pannello centrale
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Aggiunta del pannello centrale al pannello principale
        add(centerPanel, BorderLayout.CENTER);

        // Aggiunta dei listener per l'interazione utente
        accountButton.addActionListener(e -> {
            new AccountInfo(controller);
        });

        actionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                switch (actionList.getSelectedIndex()) {
                    case 0:
                        controller.setContext(Context.PLAYER_SEARCH);
                        break;
                    case 1:
                        controller.setContext(Context.TEAM_SEARCH);
                        break;
                    case 2:
                        controller.setContext(Context.TOURNAMENT_SEARCH);
                        break;
                    case 3:
                        controller.setContext(Context.TRANSFER_MARKET);
                        break;
                    case 4:
                        controller.setContext(Context.REQUEST);
                        break;
                    case 8:
                        controller.setContext(Context.LOGIN);
                        break;
                    default:
                        return;
                }
                this.setVisible(false);
                actionList.clearSelection();
            }
        });
    }
}
