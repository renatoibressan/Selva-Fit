package br.com.selvafit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.selvafit.enums.NivelAtividade;
import br.com.selvafit.enums.Objetivo;
import br.com.selvafit.enums.SexoBiologico;
import br.com.selvafit.exception.DadoInvalidoException;

public class Usuario {

    private UUID id;
    private String nome;
    private int idade;
    private SexoBiologico sexo;
    private double altura;
    private double peso;
    private Objetivo objetivo;
    private NivelAtividade nivelAtividade;

    private List<AvaliacaoFisica> avaliacoes;

    public Usuario() {
        this.avaliacoes = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) throws DadoInvalidoException {
        if (idade < 0) {
            throw new DadoInvalidoException("Idade inválida!");
        }
        this.idade = idade;
    }
    
    public SexoBiologico getSexo() {
        return sexo;
    }
    
    public void setSexo(SexoBiologico sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) throws DadoInvalidoException {
        if (altura <= 0.0) {
            throw new DadoInvalidoException("Altura inválida!");
        }
        this.altura = altura;
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

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public NivelAtividade getNivelAtividade() {
        return nivelAtividade;
    }

    public void setNivelAtividade(NivelAtividade nivelAtividade) {
        this.nivelAtividade = nivelAtividade;
    }

    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public boolean removerAvaliacao(UUID id) {
        return avaliacoes.removeIf(a -> a.getId().equals(id));
    }

    public AvaliacaoFisica getPrimeiraAvaliacao() {
        return avaliacoes.getFirst();
    }

    public AvaliacaoFisica getUltimaAvaliacao() {
        return avaliacoes.getLast();
    }

    public boolean possuiAvaliacoes() {
        return !avaliacoes.isEmpty();
    }

}
