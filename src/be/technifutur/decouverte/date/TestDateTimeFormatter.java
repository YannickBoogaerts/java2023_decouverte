package be.technifutur.decouverte.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDateTimeFormatter {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        String text = date.format(formatter);
        System.out.println(text);
        text = "21/1/2000";
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate);
    }
}
