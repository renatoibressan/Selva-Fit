package br.com.selvafit.enums;

public enum Objetivo {

    EMAGRECIMENTO("Emagrecimento"),
    HIPERTROFIA("Hipertrofia"),
    RECOMPOSICAO_CORPORAL("Recomposicao Corporal"),
    MANUTENCAO("Manutencao"),
    GANHO_DE_FORCA("Ganho de Forca"),
    CONDICIONAMENTO_FISICO("Condicionamento Fisico");

    private final String descricao;

    Objetivo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
