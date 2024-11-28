package br.unitins.tp1.loja.repository;

import br.unitins.tp1.loja.model.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    
    public Usuario findByUsername(String username) {
        return find("SELECT a FROM Administrador a WHERE a.username = ?1", username).firstResult();
    }

    public Usuario findByUsernameAndSenha(String username, String senha) {
        return find("SELECT a FROM Administrador a WHERE a.username = ?1 AND a.senha = ?2", username, senha).firstResult();
    }
}
