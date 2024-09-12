package unibo.footstats.view.requests;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Request extends JPanel {

    private JTextArea requestTextArea;
    private JComboBox<String> requestTypeComboBox;
    private JButton goBackButton;
    private JButton submitButton;
    private JButton refreshButton; // Added refresh button
    private JTable requestTable;
    private Controller controller;

    public Request(final Controller controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(800, 600)); // Larger panel size for more space

        // Set the layout manager
        setLayout(new BorderLayout());

        // Create the title label with larger sans-serif font
        JLabel titleLabel = new JLabel("Invia una richiesta");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18)); // Larger font for the title
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the request text area with a larger size
        requestTextArea = new JTextArea(15, 40); // Larger text area for more input space
        requestTextArea.setLineWrap(true);
        requestTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(requestTextArea);

        // Create the request type combo box
        String[] requestTypes = {"Aggiunta", "Modifica", "Rimozione"};
        requestTypeComboBox = new JComboBox<>(requestTypes);

        // Create the go back button
        goBackButton = new JButton("Indietro");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setContext(Context.HOME_PAGE);
                Request.super.setVisible(false);
            }
        });

        // Create the submit button
        submitButton = new JButton("Invia");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submit action here
                String request = requestTextArea.getText();
                String requestType = (String) requestTypeComboBox.getSelectedItem();
                requestTextArea.setText("");
                try {
                    controller.submitRequest(request, requestType);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Create the refresh button
        refreshButton = new JButton("Aggiorna");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRequestTable();
            }
        });

        // Create a panel for the top area components (title and text area)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel to hold the combo box
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.add(requestTypeComboBox);

        // Add the top right panel to the top panel
        topPanel.add(topRightPanel, BorderLayout.EAST);

        // Create the table to display the status of previous requests
        String[] columnNames = {"CodiceRichiesta", "Descrizione", "Tipo di Richiesta", "Stato"};
        DefaultTableModel tableModel = new NonEditableTableModel(columnNames, 0);
        requestTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(requestTable);

        // Create a panel for the table
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Stato delle Richieste Precedenti"));
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(goBackButton);
        buttonPanel.add(submitButton);
        buttonPanel.add(refreshButton);

        // Add components to the main panel
        add(topPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER); // Add table panel in the center
        add(buttonPanel, BorderLayout.SOUTH); // Add all buttons to the south



        requestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = requestTable.rowAtPoint(evt.getPoint());
                int col = requestTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    String requestID = (String) requestTable.getValueAt(row, 0);
                    String requestStatus = (String) requestTable.getValueAt(row, 3);

                    int dialogResult = JOptionPane.showConfirmDialog(null, "Vuoi eliminare la richiesta?", "Attenzione", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        controller.deleteRequest(requestID);
                        updateRequestTable();
                    }

                }
            }
        });
    }

    public void updateRequestTable() {
        String[][] data = controller.getRequestsStatus();
        DefaultTableModel tableModel = (DefaultTableModel) requestTable.getModel();
        tableModel.setRowCount(0); // Clear existing data
        for (String[] row : data) {
            tableModel.addRow(row);
        }

    }


    // Custom TableModel to make cells non-editable
    private static class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(String[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Makes all cells non-editable
        }
    }
}
