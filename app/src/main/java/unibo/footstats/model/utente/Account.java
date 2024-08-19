package unibo.footstats.model.utente;

public class Account {
    private String name;
    private String lastName;
    private String username;

    public Account(final String name,
                   final String lastName,
                   final String username) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
    }

    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getUsername() {
        return username;
    }




}

