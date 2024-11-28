package br.unitins.tp1.loja.service;

import java.util.List;

import br.unitins.tp1.loja.model.usuario.Funcionario;
import br.unitins.tp1.loja.repository.FuncionarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService{
    @Inject
    FuncionarioRepository administradorRepository;

    @Override
    public Funcionario findById(Long id) {
        return administradorRepository.findById(id);
    }


    // @Override
    // public Funcionario findByUsername(String username) {
    //     return administradorRepository.findByUsername(username);
    // }

    // @Override
    // public Funcionario findByUsernameAndSenha(String username, String senha) {
    //     return administradorRepository.findByUsernameAndSenha(username, senha);
    // }

    @Override
    public List<Funcionario> findBySetor(String setorResponsavel) {
        return administradorRepository.findBySetor(setorResponsavel);
    }

    @Override
    public List<Funcionario> findAll() {
        return administradorRepository.listAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        administradorRepository.deleteById(id);
    }
}
