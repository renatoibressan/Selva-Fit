package br.com.selvafit.dto;

import java.time.LocalDate;

public record ResumoRelatorio(
        String nomeUsuario,
        LocalDate primeiraAvaliacao,
        LocalDate ultimaAvaliacao,
        int quantidadeAvaliacoes,
        double pesoInicial,
        double pesoAtual,
        double variacaoPeso
) {
}
