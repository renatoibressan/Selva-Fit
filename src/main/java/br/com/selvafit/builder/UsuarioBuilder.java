package br.com.selvafit.builder;

import java.util.List;
import java.util.UUID;

import br.com.selvafit.enums.NivelAtividade;
import br.com.selvafit.enums.Objetivo;
import br.com.selvafit.enums.SexoBiologico;
import br.com.selvafit.exception.DadoInvalidoException;
import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.model.Usuario;

public class UsuarioBuilder {
    
    private Usuario usuario;

    public UsuarioBuilder() {
        usuario = new Usuario();
    }

    public UsuarioBuilder id(UUID id) {
        usuario.setId(id);
        return this;
    }

    public UsuarioBuilder nome(String nome) {
        usuario.setNome(nome);
        return this;
    }

    public UsuarioBuilder idade(int idade) throws DadoInvalidoException {
        usuario.setIdade(idade);
        return this;
    }

    public UsuarioBuilder sexo(SexoBiologico sexo) {
        usuario.setSexo(sexo);
        return this;
    }

    public UsuarioBuilder altura(double altura) throws DadoInvalidoException {
        usuario.setAltura(altura);
        return this;
    }

    public UsuarioBuilder peso(double peso) throws DadoInvalidoException {
        usuario.setPeso(peso);
        return this;
    }

    public UsuarioBuilder objetivo(Objetivo objetivo) {
        usuario.setObjetivo(objetivo);
        return this;
    }

    public UsuarioBuilder nivelAtividade(NivelAtividade nivelAtividade) {
        usuario.setNivelAtividade(nivelAtividade);
        return this;
    }

    public UsuarioBuilder avaliacoes(List<AvaliacaoFisica> avaliacoes) {
        usuario.setAvaliacoes(avaliacoes);
        return this;
    }

    public Usuario build() {
        return usuario;
    }
    
}
