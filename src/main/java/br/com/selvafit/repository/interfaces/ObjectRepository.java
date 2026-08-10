package br.com.selvafit.repository.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ObjectRepository<T> {

    public void salvar(T valor);
    public Optional<T> buscarPorId(UUID id);
    public List<T> buscarTodos();
    public boolean existe(UUID id);
    public boolean remover(UUID id);

}
