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

import br.com.selvafit.model.AvaliacaoFisica;
import br.com.selvafit.repository.interfaces.ObjectRepository;
import br.com.selvafit.util.JsonUtil;

public class AvaliacaoRepository implements ObjectRepository<AvaliacaoFisica> {
    
    private final ObjectMapper mapper = JsonUtil.getMapper();
    private final Path arquivo = Paths.get("data", "src/main/java/br/com/selvafit/dataset/json/avaliacoes.json");
    private List<AvaliacaoFisica> avaliacoes;

    private List<AvaliacaoFisica> carregar() {
        try {
            if (Files.notExists(arquivo)) {
                return new ArrayList<>();
            }
            return mapper.readValue(arquivo.toFile(), new TypeReference<List<AvaliacaoFisica>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar avaliacoes: ", e);
        }
    }

    private void salvarArquivo() {
        try {
            Files.createDirectories(arquivo.getParent());
            mapper.writeValue(arquivo.toFile(), avaliacoes);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar avaliacoes: ", e);
        }
    }

    public AvaliacaoRepository() {
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
                        .filter(a -> a.getId().equals(id))
                        .findFirst();
    }

    @Override
    public List<AvaliacaoFisica> buscarTodos() {
        return new ArrayList<>(avaliacoes);
    }

    @Override
    public boolean existe(UUID id) {
        return avaliacoes.stream()
                        .anyMatch(a -> a.getId().equals(id));
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
