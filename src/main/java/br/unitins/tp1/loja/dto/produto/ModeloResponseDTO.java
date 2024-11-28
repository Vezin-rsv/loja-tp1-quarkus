package br.unitins.tp1.loja.dto.produto;

import br.unitins.tp1.loja.model.produto.Modelo;

public record ModeloResponseDTO(Long id, String nome, Integer comprimento) {
    public static ModeloResponseDTO valueOf(Modelo modelo){
        return new ModeloResponseDTO(
            modelo.getId(), 
            modelo.getNome(), 
            modelo.getComprimento()
        );
    }
}
