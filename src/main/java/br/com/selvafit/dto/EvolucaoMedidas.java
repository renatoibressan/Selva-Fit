package br.com.selvafit.dto;

import java.time.LocalDate;

public record EvolucaoMedidas(
        LocalDate data,
        double cintura,
        double peito,
        double braco,
        double quadril,
        double coxa,
        double panturrilha
) {
}
