package br.unitins.tp1.loja.service;

import java.util.List;

import br.unitins.tp1.loja.model.Administrador;
import br.unitins.tp1.loja.repository.AdministradorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AdministradorServiceImpl implements AdministradorService{
    @Inject
    AdministradorRepository administradorRepository;

    @Override
    public Administrador findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador findByUsername(String username) {
        return administradorRepository.findByUsername(username);
    }

    @Override
    public Administrador findByUsernameAndSenha(String username, String senha) {
        return administradorRepository.findByUsernameAndSenha(username, senha);
    }

    @Override
    public List<Administrador> findAll() {
        return administradorRepository.listAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        administradorRepository.deleteById(id);
    }
}
