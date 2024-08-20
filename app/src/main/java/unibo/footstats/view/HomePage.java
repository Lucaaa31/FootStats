package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private JButton accountButton;
    private JList<String> actionList;
    private JLabel welcomeLabel;
    private JLabel descriptionLabel;


    public HomePage(final Controller controller) {
        // Imposta il layout principale del pannello
        setLayout(new BorderLayout());

        // Creazione e configurazione del pannello superiore per contenere l'etichetta di benvenuto e il pulsante Account
        JPanel topPanel = new JPanel(new BorderLayout());

        // Configurazione dell'etichetta di benvenuto con un font grande e centrato
        welcomeLabel = new JLabel("Welcome in FootStats!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); // Imposta il testo in grassetto e di grandi dimensioni
        welcomeLabel.setPreferredSize(new Dimension(0, 100)); // Imposta un'altezza fissa per l'etichetta
        topPanel.add(welcomeLabel, BorderLayout.CENTER); // Aggiunge l'etichetta al centro del pannello superiore

        // Creazione e configurazione del pulsante "Account" posizionato in alto a destra
        accountButton = new JButton("Account");
        topPanel.add(accountButton, BorderLayout.EAST); // Aggiunge il pulsante sul lato destro del pannello superiore

        // Aggiunta del pannello superiore al layout principale del pannello
        add(topPanel, BorderLayout.NORTH);

        // Creazione di un pannello per la descrizione con colori e bordo
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(new Color(230, 230, 250)); // Colore di sfondo lilla chiaro
        descriptionPanel.setBorder(BorderFactory.createLineBorder(new Color(72, 61, 139), 2)); // Bordo viola scuro

        // Creazione dell'etichetta di descrizione
        descriptionLabel = new JLabel("<html>"
                + "Benvenuto nella sezione di navigazione del sistema FootStats!<br>"
                + "Qui puoi esplorare diverse funzionalita' offerte dall'applicazione.<br>"
                + "Per iniziare, seleziona una delle opzioni elencate qui sotto:<br>");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Font medio
        descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT); // Centra il testo

        // Aggiunta dell'etichetta al pannello della descrizione
        descriptionPanel.add(descriptionLabel, BorderLayout.CENTER);

        // Creazione di un pannello per contenere la descrizione e la lista delle azioni
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(descriptionPanel, BorderLayout.NORTH); // Aggiunge il pannello della descrizione in alto

        // Creazione e configurazione della JList che rappresenta le opzioni disponibili
        String[] listData = {
                "-> Ricerca giocatore;",
                "-> Ricerca squadra;",
                "-> Ricerca campionato/torneo;",
                "-> Calciomercato;",
                "",
                "",
                "-> Invia una richiesta;",
                "",
                "",
                "-> Logout"
        };
        actionList = new JList<>(listData);
        actionList.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Imposta un font più grande per la lista
        actionList.setFixedCellHeight(40); // Altezza delle celle
        actionList.setVisibleRowCount(10); // Numero di righe visibili

        // Creazione di uno JScrollPane per la JList
        JScrollPane scrollPane = new JScrollPane(actionList);
        scrollPane.setPreferredSize(new Dimension(300, 300)); // Dimensioni del pannello a scorrimento

        // Aggiunta dello JScrollPane al centro del pannello della lista
        listPanel.add(scrollPane, BorderLayout.CENTER);

        // Aggiunta del pannello contenente la descrizione e la lista al layout principale
        add(listPanel, BorderLayout.CENTER);

        // Configurazione dei listener per interazioni utente
        actionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                switch (actionList.getSelectedIndex()) {
                    case 0:
                        controller.setContext(Context.PLAYER_SEARCH);
                        this.setVisible(false);
                        break;
                    case 1:

                        this.setVisible(false);
                        break;
                    case 2:

                        this.setVisible(false);
                        break;
                    case 3:

                        this.setVisible(false);
                        break;
                    case 6:

                        this.setVisible(false);
                        break;
                    case 9:
                        controller.setContext(Context.LOGIN);
                        this.setVisible(false);
                        break;
                }

            }
        });

        accountButton.addActionListener(e -> new AccountInfo(controller));
    }

    
}
