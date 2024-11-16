package br.unitins.tp1.loja.dto;

public record ItemPedidoRequestDTO (
    Long idProduto,
    Integer quantidade,
    Double preco
) {
    
}
