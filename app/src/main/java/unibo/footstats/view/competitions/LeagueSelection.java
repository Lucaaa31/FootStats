package unibo.footstats.view.competitions;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeagueSelection extends JPanel {
    private JPanel logoPanel;
    private Controller controller;

    public LeagueSelection(final Controller controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        String[] options = controller.getSeasons().toArray(new String[0]);
        options[0] = "Seleziona una stagione";

        logoPanel = new JPanel();
        logoPanel.setLayout(new GridLayout(2, 4, 10, 10)); // Adjust the grid size based on the number of logos
        add(logoPanel, BorderLayout.CENTER);

        addLogo("Serie A");
        addLogo("PL");
        addLogo("Liga");
        addLogo("Ligue1");
        addLogo("Bundesliga");
        addLogo("Champions");


    }

    private void addLogo(final String imagePath) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/competitions/" + imagePath + ".png"));
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                imagePath.equals("Serie_A") || imagePath.equals("Liga") || imagePath.equals("Ligue1") ? icon.getIconWidth() - 50 : icon.getIconWidth() - 100,
                icon.getIconHeight() - 100, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new MatteBorder(7, 7, 7, 7, Color.GRAY));
        logoPanel.add(label);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBorder(new MatteBorder(7, 7, 7, 7, Color.GREEN));
            }

            public void mouseExited(MouseEvent e) {
                label.setBorder(new MatteBorder(7, 7, 7, 7, Color.GRAY));
            }

            public void mouseClicked(MouseEvent evt) {
                controller.setCurrentCompetition(imagePath);
                controller.setContext(Context.RANKING);
                LeagueSelection.super.setVisible(false);
            }
        });
    }
}