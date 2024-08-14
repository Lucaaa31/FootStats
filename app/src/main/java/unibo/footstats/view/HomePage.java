package unibo.footstats.view;


import javax.swing.*;

public class HomePage extends JPanel {
    private JLabel welcomeLabel;
    private JLabel descriptionLabel;

    public HomePage() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        welcomeLabel = new JLabel("Welcome to FootStats!");
        descriptionLabel = new JLabel("This is a football statistics application that allows you to keep track of your favorite teams and players.");

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(welcomeLabel);
        this.add(descriptionLabel);

        setVisible(true);
    }

}
