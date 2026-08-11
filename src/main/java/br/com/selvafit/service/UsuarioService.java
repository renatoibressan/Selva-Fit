package br.com.selvafit.service;

import java.util.List;
import java.util.UUID;

import br.com.selvafit.dto.UsuarioUpdate;
import br.com.selvafit.exception.DadoInvalidoException;
import br.com.selvafit.exception.UsuarioNaoEncontradoException;
import br.com.selvafit.model.Usuario;
import br.com.selvafit.repository.interfaces.Repository;

public class UsuarioService {

    private final Repository<Usuario> repository;

    public UsuarioService(Repository<Usuario> repository) {
        this.repository = repository;
    }

    public void cadastrarUsuario(Usuario usuario) {
        repository.salvar(usuario);
    }

    public void editarUsuario(UUID id, UsuarioUpdate dados) throws DadoInvalidoException {
        Usuario usuario = repository.buscarPorId(id)
                                    .orElseThrow(
                                        () -> 
                                        new UsuarioNaoEncontradoException("Usuário " + id + " não encontrado!"));
        usuario.setNome(dados.nome());
        usuario.setIdade(dados.idade());
        usuario.setAltura(dados.altura());
        usuario.setPeso(dados.peso());
        usuario.setSexo(dados.sexo());
        usuario.setObjetivo(dados.objetivo());
        usuario.setNivelAtividade(dados.nivelAtividade());
        repository.atualizar(usuario);
    }

    public Usuario buscarPorId(UUID id) {
        return repository.buscarPorId(id)
                        .orElseThrow(
                            () -> 
                            new UsuarioNaoEncontradoException("Usuário " + id + " não encontrado!"));
    }

    public List<Usuario> listarUsuarios() {
        return repository.listarTodos();
    }

    public Usuario buscarPorNome(String nome) {
        return repository.listarTodos()
                        .stream()
                        .filter(
                            u -> 
                            u.getNome()
                            .equalsIgnoreCase(nome))
                        .findFirst()
                        .orElseThrow(
                            () -> 
                            new UsuarioNaoEncontradoException("Usuário " + nome + " não encontrado!"));
    }

    public void removerUsuario(UUID id) {
        boolean removido = repository.remover(id);
        if (!removido) {
            throw new UsuarioNaoEncontradoException("Usuário " + id + " não encontrado!");
        }
    }
    
}
