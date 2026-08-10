package br.com.selvafit.service;

import java.util.List;
import java.util.UUID;

import br.com.selvafit.dto.AvaliacaoUpdate;
import br.com.selvafit.exception.AvaliacaoNaoEncontradaException;
import br.com.selvafit.exception.DadoInvalidoException;
import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.repository.interfaces.Repository;

public class AvaliacaoService {

    private final Repository<AvaliacaoFisica> repository;

    public AvaliacaoService(Repository<AvaliacaoFisica> repository) {
        this.repository = repository;
    }

    public void registrarAvaliacao(AvaliacaoFisica avaliacao) {
        repository.salvar(avaliacao);
    }

    public void editarAvaliacao(UUID id, AvaliacaoUpdate dados) throws DadoInvalidoException {
        AvaliacaoFisica avaliacao = repository.buscarPorId(id)
                                                .orElseThrow(() -> new AvaliacaoNaoEncontradaException("Avaliação " + id + " não encontrada!"));
        avaliacao.setPeso(dados.peso());
        avaliacao.setCintura(dados.cintura());
        avaliacao.setPeito(dados.peito());
        avaliacao.setBraco(dados.braco());
        avaliacao.setQuadril(dados.quadril());
        avaliacao.setCoxa(dados.coxa());
        avaliacao.setPercentualGordura(dados.percentualGordura());
        repository.atualizar(avaliacao);
    }

    public List<AvaliacaoFisica> listarAvaliacoes() {
        return repository.listarTodos();
    }

    public AvaliacaoFisica buscarUltimaAvaliacao() {
        return repository.listarTodos()
                        .getLast();
    }

    public void removerAvaliacao(UUID id) {
        boolean removido = repository.remover(id);
        if (!removido) {
            throw new AvaliacaoNaoEncontradaException("Avaliação " + id + " não encontrada!");
        }
    }
    
}
