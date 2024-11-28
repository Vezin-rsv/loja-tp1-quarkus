package br.unitins.tp1.loja.repository;

import java.util.List;

import br.unitins.tp1.loja.model.usuario.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>{
    
    public List<Funcionario> findBySetor(String setorResponsavel) {
        return find("SELECT f FROM Funcionario f WHERE f.setorResponsavel LIKE ?1", "%" + setorResponsavel + "%").list();
    }
}
