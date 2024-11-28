package br.unitins.tp1.loja.service;

import java.util.List;

import br.unitins.tp1.loja.model.usuario.Funcionario;

public interface FuncionarioService {
    
    Funcionario findById(Long id);

    List<Funcionario> findBySetor(String setorResponsavel);

    // Funcionario findByUsername(String username);

    // Funcionario findByUsernameAndSenha(String username, String senha);

    List<Funcionario> findAll();

    // Administrador create(AdministradorRequestDTO dto);

    // Administrador update(Long id, AdministradorRequestDTO dto);

    void delete(Long id); 
    
}
