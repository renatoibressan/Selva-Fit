package br.com.selvafit.dto;

import java.time.LocalDate;

public record EvolucaoPeso(
        LocalDate data,
        double valor
) {
}
