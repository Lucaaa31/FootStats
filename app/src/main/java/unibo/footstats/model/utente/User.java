package unibo.footstats.model.utente;

public class User extends Account {
    private String email;
    private String label;

    public User(final String name,
                final String lastName,
                final String username,
                final String password,
                final String email) {
        super(name, lastName, username, password);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }
}
