package unibo.footstats.model.utente;

import java.util.List;
import java.util.Objects;

public class User extends Account {
    private String etichetta;

    public User(final String name,
                final String lastName,
                final String username,
                final String etichetta) {
        super(name, lastName, username);
        this.etichetta = Objects.requireNonNullElse(etichetta, "N/A");
    }

    public List<String> getCredentials() {
        return List.of(getName(), getLastName(), getUsername(), getEtichetta());
    }

    public String getEtichetta() {
        return etichetta;
    }

    public void setEtichetta(final String etichetta) {
        this.etichetta = etichetta;
    }
}
