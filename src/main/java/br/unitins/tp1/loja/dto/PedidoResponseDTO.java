package br.unitins.tp1.loja.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.loja.model.Pedido;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime dataPedido,
    Double valorTotal,
    List<ItemPedidoResponseDTO> listaItemPedido

) {
   public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getDataPedido(),
            pedido.getValorTotal(),
            pedido.getListaItemPedidos().stream().map(i -> ItemPedidoResponseDTO.valueOf(i)).toList()
        );
      
    } 
}
