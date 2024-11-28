package br.unitins.tp1.loja.dto.pedido;

import br.unitins.tp1.loja.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO (Long idProduto, String nome, Integer quantidade, Double valor) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO(
            itemPedido.getLote().getVentilador().getId(), 
            itemPedido.getLote().getVentilador().getNome(), 
            itemPedido.getQuantidade(),
            itemPedido.getPreco());
    }
    
}
