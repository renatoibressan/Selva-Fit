package app.enums;

public enum NivelAtividade {
    
    SEDENTARIO("Sedentario"),
    LEVEMENTE_ATIVO("Levemente ativo"),
    MODERADAMENTE_ATIVO("Moderadamente ativo"),
    MUITO_ATIVO("Muito ativo"),
    EXTREMAMENTE_ATIVO("Extremamente ativo");

    private final String descricao;

    NivelAtividade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
