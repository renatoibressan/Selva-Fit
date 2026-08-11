package br.com.selvafit.dto;

public record ComparacaoMedida(
        double valorInicial,
        double valorFinal,
        double variacaoMetrica,
        double variacaoPercentual
) {
}
