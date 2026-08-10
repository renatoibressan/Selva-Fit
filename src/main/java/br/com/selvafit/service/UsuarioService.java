package br.com.selvafit.service;

import java.util.ArrayList;
import java.util.List;

import br.com.selvafit.model.Usuario;
import br.com.selvafit.repository.interfaces.ObjectRepository;

public class UsuarioService {

    private ObjectRepository<Usuario> repository;
    private List<Usuario> usuarios;

    public UsuarioService(ObjectRepository<Usuario> repository) {
        this.repository = repository;
        usuarios = new ArrayList<>();
    }
    
}
