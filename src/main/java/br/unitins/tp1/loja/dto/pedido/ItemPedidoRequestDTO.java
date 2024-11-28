package br.unitins.tp1.loja.dto.pedido;

public record ItemPedidoRequestDTO (
    Long idProduto,
    Integer quantidade,
    Double preco
) {
    
}
