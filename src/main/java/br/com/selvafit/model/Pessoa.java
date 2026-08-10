package br.com.selvafit.model;

import br.com.selvafit.enums.SexoBiologico;
import br.com.selvafit.exception.DadoInvalidoException;

public class Pessoa {
    
    private String nome;
    private int idade;
    private SexoBiologico sexo;

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

}
