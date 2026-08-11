package br.com.selvafit.repository.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.selvafit.exception.AvaliacaoNaoEncontradaException;
import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.repository.interfaces.Repository;
import br.com.selvafit.util.JsonUtil;

public class JsonAvaliacaoRepository implements Repository<AvaliacaoFisica> {
    
    private final ObjectMapper mapper = JsonUtil.getMapper();
    private final Path arquivo = Paths.get("data", "avaliacoes.json");
    private List<AvaliacaoFisica> avaliacoes;

    private List<AvaliacaoFisica> carregar() {
        try {
            if (Files.notExists(arquivo)) {
                return new ArrayList<>();
            }
            return mapper.readValue(arquivo.toFile(), 
                                    new TypeReference<List<AvaliacaoFisica>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar avaliações: ", e);
        }
    }

    private void salvarArquivo() {
        try {
            Files.createDirectories(arquivo.getParent());
            mapper.writeValue(
                arquivo.toFile(), 
                avaliacoes
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar avaliações: ", e);
        }
    }

    public JsonAvaliacaoRepository() {
        avaliacoes = carregar();
    }

    @Override
    public void salvar(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
        salvarArquivo();
    }

    @Override
    public Optional<AvaliacaoFisica> buscarPorId(UUID id) {
        return avaliacoes.stream()
                        .filter(
                            a -> 
                            a.getId().equals(id)
                        )
                        .findFirst();
    }

    @Override
    public List<AvaliacaoFisica> listarTodos() {
        return new ArrayList<>(avaliacoes);
    }

    @Override
    public void atualizar(AvaliacaoFisica avaliacao) {
        for (int i = 0; i < avaliacoes.size(); i++) {
            if (avaliacoes.get(i)
                        .getId()
                        .equals(
                            avaliacao.getId()
                        )) {
                avaliacoes.set(i, avaliacao);
                salvarArquivo();
                return;
            }
        }
        throw new AvaliacaoNaoEncontradaException("Avaliação " + avaliacao.getId() + " não encontrada!");
    }

    @Override
    public boolean remover(UUID id) {
        boolean removido = avaliacoes.removeIf(a -> a.getId().equals(id));
        if (removido) {
            salvarArquivo();
        }
        return removido;
    }

}
