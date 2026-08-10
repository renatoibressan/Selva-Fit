package br.com.selvafit.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public final class DataUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate hoje() {
        return LocalDate.now();
    }

    public static String formatar(LocalDate data) {
        return data.format(FORMATTER);
    }

    public static LocalDate converter(String data) {
        return LocalDate.parse(data, FORMATTER);
    }

    public static int diferencaEmDias(LocalDate inicio, LocalDate fim) {
        return Period.between(inicio, fim).getDays();
    }
    
}
