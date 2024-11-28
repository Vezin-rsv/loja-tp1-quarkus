package br.unitins.tp1.loja.service;
import java.util.List;

import br.unitins.tp1.loja.model.usuario.Usuario;


public interface UsuarioService {

    Usuario findById(Long id);

    Usuario findByUsername(String username);

    Usuario findByUsernameAndSenha(String username, String senha);

    List<Usuario> findAll();

    // Usuario updateNomeImagem(Long id, String nomeImagem);

    // Usuario create(UsuarioRequestDTO dto);

    // Usuario update(Long id, UsuarioRequestDTO dto);

    void delete(Long id); 
}
