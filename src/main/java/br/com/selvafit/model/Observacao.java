package br.com.selvafit.model;

import java.time.LocalDate;
import java.util.UUID;

public class Observacao {
    
    private UUID id;
    private LocalDate data;
    private String descricao;

    public Observacao(UUID id, LocalDate data, String descricao) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
