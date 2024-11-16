package br.unitins.tp1.loja.dto;

import br.unitins.tp1.loja.model.Cor;
import br.unitins.tp1.loja.model.Ventilador;
import br.unitins.tp1.loja.model.Voltagem;

public record VentiladorResponseDTO(Long id, String nome, Double preco, String descricao, Voltagem voltagem, 
Cor cor, String nomeImagem, ModeloResponseDTO modelo, FabricanteResponseDTO fabricante, FornecedorResponseDTO fornecedor) {
    public static VentiladorResponseDTO valueOf(Ventilador ventilador){
        return new VentiladorResponseDTO(
            ventilador.getId(), 
            ventilador.getNome(), 
            ventilador.getPreco(), 
            ventilador.getDescricao(), 
            ventilador.getVoltagem(), 
            ventilador.getCor(), 
            ventilador.getNomeImagem(),
            ModeloResponseDTO.valueOf(ventilador.getModelo()),
            FabricanteResponseDTO.valueOf(ventilador.getFabricante()),
            FornecedorResponseDTO.valueOf(ventilador.getFornecedor())
        );
    }
}
