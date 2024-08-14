package unibo.footstats.model.utente;

public class Account {
    private String name;
    private String lastName;
    private String username;
    private String password;

    public Account(final String name,
                   final String lastName,
                   final String username,
                   final String password) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }



}

