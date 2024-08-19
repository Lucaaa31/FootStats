package unibo.footstats.model.partita;

import java.sql.Date;

public record Partita(
    String idPartita,
    String squadraCasa,
    String squadraOspite,
    Date data,
    String risultato,
    String competizione,
    String stagione
) {

}
