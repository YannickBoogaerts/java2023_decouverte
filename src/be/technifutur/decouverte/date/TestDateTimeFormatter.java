package be.technifutur.decouverte.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDateTimeFormatter {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        DateTimeFormatter writerFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");
        DateTimeFormatter readerFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        String text = date.format(writerFormatter);
        System.out.println(text);
        text = "21/1/2000";
        LocalDate parsedDate = LocalDate.parse(text, readerFormatter);
        System.out.println(parsedDate.format(writerFormatter));
    }
}
