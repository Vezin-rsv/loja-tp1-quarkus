package br.unitins.tp1.loja.repository;

import java.util.List;

import br.unitins.tp1.loja.model.usuario.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{

    public Cliente findByCpf(String cpf) {
        return find("SELECT c FROM Cliente c WHERE c.cpf = ?1", cpf).firstResult();
    }

    public List<Cliente> findByNome(String nome) {
        return find("SELECT u FROM Cliente u WHERE u.username LIKE ?1", "%" + nome + "%").list();
    }

    

    
}
