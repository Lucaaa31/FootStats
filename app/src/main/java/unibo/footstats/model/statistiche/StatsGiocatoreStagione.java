package unibo.footstats.model.statistiche;

import unibo.footstats.model.stagione.Stagione;

public record StatsGiocatoreStagione(
        String cfGiocatore,
        String name,
        String lastName,
        Stagione AnnoCalcistico,
        int codiceStatsStagionale,
        int goal,
        int assist,
        int cartellini,
        double valoreDiMercato,
        int presenze,
        int numeroMaglia,
        String ruolo
) {


}
