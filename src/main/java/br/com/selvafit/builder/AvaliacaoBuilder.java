package br.com.selvafit.builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.selvafit.exception.DadoInvalidoException;
import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.model.Observacao;

public class AvaliacaoBuilder {
    
    private AvaliacaoFisica avaliacao;

    public AvaliacaoBuilder() {
        avaliacao = new AvaliacaoFisica();
    }

    public AvaliacaoBuilder id(UUID id) {
        avaliacao.setId(id);
        return this;
    }

    public AvaliacaoBuilder data(LocalDate data) {
        avaliacao.setData(data);
        return this;
    }

    public AvaliacaoBuilder peso(double peso) throws DadoInvalidoException {
        avaliacao.setPeso(peso);
        return this;
    }

    public AvaliacaoBuilder cintura(double cintura) throws DadoInvalidoException {
        avaliacao.setCintura(cintura);
        return this;
    }

    public AvaliacaoBuilder peito(double peito) throws DadoInvalidoException {
        avaliacao.setPeito(peito);
        return this;
    }

    public AvaliacaoBuilder braco(double braco) throws DadoInvalidoException {
        avaliacao.setBraco(braco);
        return this;
    }

    public AvaliacaoBuilder quadril(double quadril) throws DadoInvalidoException {
        avaliacao.setQuadril(quadril);
        return this;
    }

    public AvaliacaoBuilder coxa(double coxa) throws DadoInvalidoException {
        avaliacao.setCoxa(coxa);
        return this;
    }

    public AvaliacaoBuilder percentualGordura(double percentualGordura) throws DadoInvalidoException {
        avaliacao.setPercentualGordura(percentualGordura);
        return this;
    }

    public AvaliacaoBuilder observacoes(List<Observacao> observacoes) {
        avaliacao.setObservacoes(observacoes);
        return this;
    }

    public AvaliacaoFisica build() {
        return avaliacao;
    }

}
