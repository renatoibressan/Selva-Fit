package br.com.selvafit.dto;

import java.time.LocalDate;

public record ComparacaoAvaliacao(
        LocalDate dataInicial,
        LocalDate dataFinal,
        ComparacaoMedida peso,
        ComparacaoMedida cintura,
        ComparacaoMedida peito,
        ComparacaoMedida braco,
        ComparacaoMedida quadril,
        ComparacaoMedida coxa,
        ComparacaoMedida panturrilha,
        ComparacaoMedida percentualGordura
) {
}
