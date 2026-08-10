package br.com.selvafit.repository.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repository<T> {

    public void salvar(T valor);
    public Optional<T> buscarPorId(UUID id);
    public List<T> listarTodos();
    public void atualizar(T valor);
    public boolean remover(UUID id);

}
