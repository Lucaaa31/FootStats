package unibo.footstats.model.statistiche;

import unibo.footstats.model.stagione.Stagione;

public record PlayerStats(
        String cfGiocatore,
        String name,
        String lastName,
        String AnnoCalcistico,
        int goal,
        int assist,
        int cartellini,
        double valoreDiMercato,
        int presenze,
        int numeroMaglia,
        String ruolo
) {
}
