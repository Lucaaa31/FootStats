package unibo.footstats.model.calciatore;

import java.sql.Date;

public record Contratto(
    String cfGiocatore,
    Date dataInizio,
    int durata,
    double valore
) {

}
