package unibo.footstats.model.calciatore;

import java.sql.Date;


public record Calciatore(
        String name,
        String lastName,
        Date birthDate,
        float height,
        String birthPlace,
        String preferredFoot
) {





}
