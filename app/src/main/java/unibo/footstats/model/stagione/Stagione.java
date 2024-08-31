package unibo.footstats.model.stagione;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record Stagione(
        String dataInizio,
        String dataFine
) {
    public String getSeason() {
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parse the start and end dates
        LocalDate startDate = LocalDate.parse(dataInizio, formatter);
        LocalDate endDate = LocalDate.parse(dataFine, formatter);

        // Extract the years from the start and end dates
        int startYear = startDate.getYear();
        int endYear = endDate.getYear();

        // Return the season span in the format "yyyy/yyyy"
        return startYear + "/" + endYear;
    }
}
