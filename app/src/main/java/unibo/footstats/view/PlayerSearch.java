package unibo.footstats.view;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;
import unibo.footstats.utility.PlayerResult;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlayerSearch extends JPanel {
    private JTextField searchField;
    private JTable resultTable;
    private JButton backButton;
    private List<PlayerResult> resultSet;

    public PlayerSearch(final Controller controller) {
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Cerca");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        String[] columnNames = {"Nome", "Cognome", "Ruolo", "Squadra", "Nazionalita'", "Valore di mercato"};
        Object[][] data = {};

        // Override the DefaultTableModel to make cells non-editable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };


        resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        // ActionListener per il pulsante di ricerca
        searchButton.addActionListener(e -> {
            tableModel.setRowCount(0); // Clear existing rows
            resultSet = controller.searchPlayer(searchField.getText());

            for (PlayerResult player : resultSet) {
                tableModel.addRow(new Object[]{player.name(), player.lastName(), player.role(), player.team(), player.nationality(), player.marketValue()});
            }
        });

        // MouseListener to handle row click events
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && resultTable.getSelectedRow() != -1) { // Double-click detected
                    int row = resultTable.getSelectedRow();
                    String name = (String) resultTable.getValueAt(row, 0);
                    String lastName = (String) resultTable.getValueAt(row, 1);

                    controller.setPlayer(resultSet.get(resultTable.getSelectedRow()).CF());
                    controller.setContext(Context.PLAYER_STATISTICS);

                    PlayerSearch.super.setVisible(false);
                    resultTable.clearSelection();
                    searchField.setText("");
                }
            }
        });

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("Back");
        backPanel.add(backButton);
        add(backPanel, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            controller.setContext(Context.HOME_PAGE);
            this.setVisible(false);
        });
    }
}
