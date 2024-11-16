package br.unitins.tp1.loja.service;

import java.util.List;

import br.unitins.tp1.loja.model.Administrador;

public interface AdministradorService {
    
    Administrador findById(Long id);

    Administrador findByUsername(String username);

    Administrador findByUsernameAndSenha(String username, String senha);

    List<Administrador> findAll();

    // Administrador create(AdministradorRequestDTO dto);

    // Administrador update(Long id, AdministradorRequestDTO dto);

    void delete(Long id); 
    
}
