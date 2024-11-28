package br.unitins.tp1.loja.repository;

import java.util.List;

import br.unitins.tp1.loja.model.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido>{
    
    public List<Pedido> findByCliente(Long idCliente) {
        return find("SELECT p FROM Pedido p WHERE p.cliente.id = ?1", idCliente).list();
    }
}
