package unibo.footstats.view.competitions;

import unibo.footstats.controller.Controller;
import unibo.footstats.utility.Context;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NationalSelection extends JPanel {
    private JPanel pannelloImmagini = new JPanel();


    public NationalSelection(final Controller controller) {
        // Imposta layout del pannello
        setLayout(new BorderLayout());

        // Crea il JComboBox per le stagioni
        String[] stagioni = controller.getSeasons().toArray(new String[0]);


        // Pannello centrale per le immagini
        pannelloImmagini.setLayout(new GridLayout(1, 3));

        addLogo("Mondiali");
        addLogo("Euro");
        addLogo("America");


        add(pannelloImmagini, BorderLayout.CENTER);


    }


    private void addLogo(final String imagePath) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/competitions/" + imagePath + ".png"));
        icon = new ImageIcon(icon.getImage().getScaledInstance(icon.getIconWidth() - 100,
                icon.getIconHeight() - 100, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(icon);
        label.setBackground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new MatteBorder(7, 7, 7, 7, Color.GRAY));
        pannelloImmagini.add(label);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBorder(new MatteBorder(7, 7, 7, 7, Color.GREEN));
            }

            public void mouseExited(MouseEvent e) {
                label.setBorder(new MatteBorder(7, 7, 7, 7, Color.GRAY));
            }

            public void mouseClicked(MouseEvent evt) {

            }
        });
    }

}

