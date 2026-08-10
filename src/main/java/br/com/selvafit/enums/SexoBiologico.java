package br.com.selvafit.enums;

public enum SexoBiologico {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;

    SexoBiologico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
