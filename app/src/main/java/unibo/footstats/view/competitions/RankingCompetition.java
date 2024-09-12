package unibo.footstats.view.competitions;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RankingCompetition extends JPanel {
    private String[][] datiSquadre;

    public RankingCompetition(final Controller controller) {
        setLayout(new BorderLayout());

        String[] stagioni = controller.getSeasons().toArray(new String[0]);
        stagioni[0] = "Seleziona una stagione...";
        JComboBox<String> comboBoxStagioni = new JComboBox<>(stagioni);
        add(comboBoxStagioni, BorderLayout.NORTH);

        String[] nomiColonne = {"Posizione", "Nome", "V", "N", "P", "Punti"};

        DefaultTableModel modelloTabella = new DefaultTableModel(null, nomiColonne);

        JTable tabellaClassifica = new JTable(modelloTabella);
        tabellaClassifica.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabellaClassifica);
        add(scrollPane, BorderLayout.CENTER);


        comboBoxStagioni.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
            String stagione = (String) cb.getSelectedItem();
            modelloTabella.setRowCount(0);
            if (!stagione.equals("Seleziona una stagione...")) {
                datiSquadre = controller.getRanking(stagione);
                for (String[] squadra : datiSquadre) {
                    modelloTabella.addRow(squadra);
                }
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                comboBoxStagioni.setSelectedIndex(0);
                modelloTabella.setRowCount(0);
            }
        });


    }
}
