package br.unitins.tp1.loja.dto.pedido;
import java.util.List;

public record PedidoRequestDTO (
    Double valorTotal,
    List<ItemPedidoRequestDTO> listaItemPedido
){
}
