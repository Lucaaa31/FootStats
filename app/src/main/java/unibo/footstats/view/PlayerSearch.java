package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PlayerSearch extends JPanel {
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultArea;
    private JComboBox nationalityBox;
    private JButton backButton;


    public PlayerSearch(final Controller controller) {
        // Imposta il layout del pannello
        setLayout(new BorderLayout());

        // Crea il pannello per la ricerca
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        // Crea la casella di testo per l'inserimento del nome del giocatore
        searchField = new JTextField(20);
        searchPanel.add(new JLabel("Player:"));
        searchPanel.add(searchField);

        // Crea la JComboBox per la selezione della nazionalità
        final String[] nations = {"All",
                "Italy", "England",
                "Spain", "Germany",
                "France", "Portugal",
                "Argentina", "Brazil",
                "Netherlands", "Belgium"};

        nationalityBox = new JComboBox<>(nations);
        searchPanel.add(new JLabel("Nazionalita':"));
        searchPanel.add(nationalityBox);

        // Crea il pulsante di ricerca
        searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        // Aggiunge il pannello di ricerca al pannello principale
        add(searchPanel, BorderLayout.NORTH);

        // Crea l'area di testo per mostrare i risultati della ricerca
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        // Crea il pannello per il pulsante di ritorno
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("Back");
        backPanel.add(backButton);
        add(backPanel, BorderLayout.SOUTH);

        // Aggiunge l'azione al pulsante di ricerca
        searchButton.addActionListener(e -> {
            if (searchField.getText().contains(" ")){
                final String[] fullName = searchField.getText().split(" ");
                String name = fullName[0];
                String lastName = fullName[1];

            }
            String nation = Objects.equals(Objects.requireNonNull(nationalityBox.getSelectedItem()).toString(), "All")
                    ? "*" : nationalityBox.getSelectedItem().toString();
            //resultArea.setText(controller.searchPlayer(player, nation));
        });

        backButton.addActionListener(e -> {
            controller.setContext(Context.HOME_PAGE);
            this.setVisible(false);
        });


    }
}
