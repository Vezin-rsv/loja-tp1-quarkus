package br.unitins.tp1.loja.service;

import java.util.List;
import br.unitins.tp1.loja.model.Usuario;
import br.unitins.tp1.loja.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario findByUsernameAndSenha(String username, String senha) {
        return usuarioRepository.findByUsernameAndSenha(username, senha);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.listAll();
    }

    @Override
    @Transactional
    public Usuario updateNomeImagem(Long id, String nomeImagem) {
        Usuario usuario = usuarioRepository.findById(id);

        usuario.setNomeImagem(nomeImagem);
        
        return usuario;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
