package br.unitins.tp1.loja.service;
import java.util.List;

import br.unitins.tp1.loja.model.usuario.Cliente;


public interface ClienteService {

    Cliente findById(Long id);

    // Cliente findByUsername(String username);

    // Cliente findByUsernameAndSenha(String username, String senha);

    List<Cliente> findByNome (String nome);

    List<Cliente> findAll();

    // Cliente updateNomeImagem(Long id, String nomeImagem);

    // Cliente create(ClienteRequestDTO dto);

    // Cliente update(Long id, ClienteRequestDTO dto);

    void delete(Long id); 
}
