package unibo.footstats.view;

import unibo.footstats.controller.Controller;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


public class AccountInfo extends JOptionPane {

    public AccountInfo(final Controller controller) {
        List<String> credentials = controller.getCredentials();
        String message = "<html>"
                + "<h2>Informazioni Account</h2>"
                + "<p><strong>Nome:</strong> " + credentials.get(0) + "</p>"
                + "<p><strong>Cognome:</strong> " + credentials.get(1) + "</p>"
                + "<p><strong>Username:</strong> " + credentials.get(2) + "</p>"
                + "<p><strong>Targhetta:</strong> " + credentials.get(3) + "</p>"
                + "</html>";

        // Visualizzazione del messaggio con le informazioni dell'account in una finestra di dialogo
        showMessageDialog(null, message, "Account Information", INFORMATION_MESSAGE);
    }
}