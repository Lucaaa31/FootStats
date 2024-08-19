package unibo.footstats.model.palmares;

import java.util.List;

public class PalmaresSquadra {
    private String nomeSquadra;
    private List<Trofeo> trofei;

    public PalmaresSquadra(final String nomeSquadra, final List<Trofeo> trofei) {
        this.nomeSquadra = nomeSquadra;
        this.trofei = trofei;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public List<Trofeo> getTrofei() {
        return trofei;
    }
}
