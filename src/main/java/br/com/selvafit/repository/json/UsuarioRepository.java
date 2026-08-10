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

import br.com.selvafit.model.Usuario;
import br.com.selvafit.repository.interfaces.ObjectRepository;
import br.com.selvafit.util.JsonUtil;

public class UsuarioRepository implements ObjectRepository<Usuario> {
    
    private final ObjectMapper mapper = JsonUtil.getMapper();
    private final Path arquivo = Paths.get("data", "src/main/java/br/com/selvafit/dataset/json/usuarios.json");
    private List<Usuario> usuarios;

    private List<Usuario> carregar() {
        try {
            if (Files.notExists(arquivo)) {
                return new ArrayList<>();
            }
            return mapper.readValue(arquivo.toFile(), new TypeReference<List<Usuario>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar usuarios: ", e);
        }
    }   

    private void salvarArquivo() {
        try {
            Files.createDirectories(arquivo.getParent());
            mapper.writeValue(arquivo.toFile(), usuarios);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar usuarios: ", e);
        }
    }

    public UsuarioRepository() {
        usuarios = carregar();
    }
    
    @Override
    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
        salvarArquivo();
    }

    @Override
    public Optional<Usuario> buscarPorId(UUID id) {
        return usuarios.stream()
                        .filter(u -> u.getId().equals(id))
                        .findFirst();
    }

    @Override
    public List<Usuario> buscarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public boolean existe(UUID id) {
        return usuarios.stream()
                        .anyMatch(u -> u.getId().equals(id));
    }

    @Override
    public boolean remover(UUID id) {
        boolean removido = usuarios.removeIf(u -> u.getId().equals(id));
        if (removido) {
            salvarArquivo();
        }
        return removido;
    }
    
}
