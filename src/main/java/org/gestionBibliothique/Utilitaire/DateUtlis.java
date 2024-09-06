package org.gestionBibliothique.Utilitaire;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtlis {
    public static LocalDate parseDate(String date) {
        try {
            //Patterns for Formatting and Parsing
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Date invalide, veuillez réessayer.");
            return null;
        }
    }
}
