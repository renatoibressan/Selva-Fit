package br.com.selvafit.dto;

public record AvaliacaoUpdate(
        double peso,
        double cintura,
        double peito,
        double braco,
        double quadril,
        double coxa,
        double percentualGordura
) {
}
