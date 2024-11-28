package br.unitins.tp1.loja.service;

import java.util.List;

import br.unitins.tp1.loja.model.usuario.Cliente;
import br.unitins.tp1.loja.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService{

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id);
    }

    // Arrumarrrrr
    // @Override
    // public Cliente findByUsername(String username) {
    //     return clienteRepository.findByUsername(username);
    // }

    // @Override
    // public Cliente findByUsernameAndSenha(String username, String senha) {
    //     return clienteRepository.findByUsernameAndSenha(username, senha);
    // }
    @Override
    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.listAll();
    }

    // @Override
    // @Transactional
    // public Cliente updateNomeImagem(Long id, String nomeImagem) {
    //     Cliente cliente = clienteRepository.findById(id);

    //     cliente.setNomeImagem(nomeImagem);
        
    //     return cliente;
    // }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
