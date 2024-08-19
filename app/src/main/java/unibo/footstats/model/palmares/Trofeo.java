package unibo.footstats.model.palmares;

import java.util.*;

public class Trofeo extends HashMap<String, Integer> {

    public Trofeo(final String nomeTrofeo, final Integer quantita) {
        super();
        this.put(nomeTrofeo, quantita);
    }



}
