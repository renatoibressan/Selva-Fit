package br.com.selvafit.enums;

public enum Objetivo {

    EMAGRECIMENTO("Emagrecimento"),
    HIPERTROFIA("Hipertrofia"),
    RECOMPOSICAO_CORPORAL("Recomposição Corporal"),
    MANUTENCAO("Manutenção"),
    GANHO_DE_FORCA("Ganho de Força"),
    CONDICIONAMENTO_FISICO("Condicionamento Físico");

    private final String descricao;

    Objetivo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
