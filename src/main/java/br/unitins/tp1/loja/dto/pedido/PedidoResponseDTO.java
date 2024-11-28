package br.unitins.tp1.loja.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.loja.model.pedido.Pedido;

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
