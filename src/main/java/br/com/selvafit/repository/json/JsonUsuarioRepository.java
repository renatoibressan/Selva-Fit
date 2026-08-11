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

import br.com.selvafit.exception.UsuarioNaoEncontradoException;
import br.com.selvafit.model.Usuario;
import br.com.selvafit.repository.interfaces.Repository;
import br.com.selvafit.util.JsonUtil;

public class JsonUsuarioRepository implements Repository<Usuario> {
    
    private final ObjectMapper mapper = JsonUtil.getMapper();
    private final Path arquivo = Paths.get("data", "usuarios.json");

    private List<Usuario> usuarios;

    private List<Usuario> carregar() {
        try {
            if (Files.notExists(arquivo)) {
                return new ArrayList<>();
            }
            return mapper.readValue(arquivo.toFile(), 
                                    new TypeReference<List<Usuario>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar usuários: ", e);
        }
    }   

    private void salvarArquivo() {
        try {
            Files.createDirectories(arquivo.getParent());
            mapper.writeValue(
                arquivo.toFile(), 
                usuarios
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar usuários: ", e);
        }
    }

    public JsonUsuarioRepository() {
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
                        .filter(
                            u -> 
                            u.getId().equals(id)
                        )
                        .findFirst();
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void atualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i)
                        .getId()
                        .equals(
                            usuario.getId()
                        )) {
                usuarios.set(i, usuario);
                salvarArquivo();
                return;
            }
        }
        throw new UsuarioNaoEncontradoException("Usuário " + usuario.getId() + " não encontrado!");
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
