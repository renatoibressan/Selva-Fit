package br.com.selvafit.dto;

import br.com.selvafit.enums.NivelAtividade;
import br.com.selvafit.enums.Objetivo;
import br.com.selvafit.enums.SexoBiologico;

public record UsuarioUpdate(
        String nome,
        int idade,
        double altura,
        double peso,
        SexoBiologico sexo,
        Objetivo objetivo,
        NivelAtividade nivelAtividade
) {
}
