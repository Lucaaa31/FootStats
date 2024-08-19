package unibo.footstats.model.partita;

public record StatsGiocatorePartita(
    String cfGiocatore,
    String AnnoCalcistico,
    String TipoCompetizione,
    int codicePartita,
    int codiceStatsPartita,
    int goal,
    int assist,
    int cartellini
) {

}
