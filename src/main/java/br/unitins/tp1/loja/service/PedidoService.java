package br.unitins.tp1.loja.service;

import java.util.List;

import br.unitins.tp1.loja.dto.pedido.PedidoRequestDTO;
import br.unitins.tp1.loja.model.pedido.Pedido;

public interface PedidoService {

    Pedido findById(Long id);

    List<Pedido> findByUsername(String username);

    Pedido create(PedidoRequestDTO dto);

    //implementar os patchs

    void delete(Long id); 
}
