package br.unitins.tp1.loja.dto.produto;

import br.unitins.tp1.loja.dto.FabricanteResponseDTO;
import br.unitins.tp1.loja.dto.FornecedorResponseDTO;
import br.unitins.tp1.loja.model.produto.Cor;
import br.unitins.tp1.loja.model.produto.Ventilador;
import br.unitins.tp1.loja.model.produto.Voltagem;

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
