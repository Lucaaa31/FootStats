package unibo.footstats.model.statistiche;

import unibo.footstats.model.stagione.Stagione;

public record StatsGiocatorePartita(
    String cfGiocatore,
    Stagione AnnoCalcistico,
    String TipoCompetizione,
    int codicePartita,
    int codiceStatsPartita,
    int goal,
    int assist,
    int cartellini
) {

}
