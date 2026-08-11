package br.com.selvafit.dto;

public record ResumoCorporal(
        double pesoInicial,
        double pesoAtual,
        double variacaoPeso,
        double percentualGorduraInicial,
        double percentualGorduraAtual,
        double variacaoPercentualGordura
) {
}
