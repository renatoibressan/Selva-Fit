package br.com.selvafit.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.selvafit.exception.DadoInvalidoException;

public class AvaliacaoFisica {
    
    private UUID id;
    private LocalDate data;
    private double peso;
    private double cintura;
    private double peito;
    private double braco;
    private double quadril;
    private double coxa;
    private double percentualGordura;
    private List<Observacao> observacoes;

    public AvaliacaoFisica() {
        this.observacoes = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws DadoInvalidoException {
        if (peso <= 0.0) {
            throw new DadoInvalidoException("Peso inválido!");
        }
        this.peso = peso;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) throws DadoInvalidoException {
        if (cintura <= 0.0) {
            throw new DadoInvalidoException("Medida inválida!");
        }
        this.cintura = cintura;
    }

    public double getPeito() {
        return peito;
    }

    public void setPeito(double peito) throws DadoInvalidoException {
        if (peito <= 0.0) {
            throw new DadoInvalidoException("Medida inválida!");
        }
        this.peito = peito;
    }

    public double getBraco() {
        return braco;
    }

    public void setBraco(double braco) throws DadoInvalidoException {
        if (braco <= 0.0) {
            throw new DadoInvalidoException("Medida inválida!");
        }
        this.braco = braco;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) throws DadoInvalidoException {
        if (quadril <= 0.0) {
            throw new DadoInvalidoException("Medida inválida!");
        }
        this.quadril = quadril;
    }

    public double getCoxa() {
        return coxa;
    }

    public void setCoxa(double coxa) throws DadoInvalidoException {
        if (coxa <= 0.0) {
            throw new DadoInvalidoException("Medida inválida!");
        }
        this.coxa = coxa;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) throws DadoInvalidoException {
        if (percentualGordura < 0.0 || percentualGordura > 100.0) {
            throw new DadoInvalidoException("Percentual inválido!");
        }
        this.percentualGordura = percentualGordura;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    public void adicionarObservacao(Observacao observacao) {
        observacoes.add(observacao);
    }

    public boolean removerObservacao(UUID id) {
        return observacoes.removeIf(o -> o.getId().equals(id));
    }

    public void listarObservacoes() {
        observacoes.forEach(obs -> System.out.println(obs.getData().toString() + ": " + obs.getDescricao()));
        System.out.println();
    }

}
