package br.com.selvafit.service;

import java.util.ArrayList;
import java.util.List;

import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.repository.interfaces.ObjectRepository;

public class AvaliacaoService {

    private ObjectRepository<AvaliacaoFisica> repository;
    private List<AvaliacaoFisica> avaliacoes;

    public AvaliacaoService(ObjectRepository<AvaliacaoFisica> repository) {
        this.repository = repository;
        avaliacoes = new ArrayList<>();
    }
    
}
