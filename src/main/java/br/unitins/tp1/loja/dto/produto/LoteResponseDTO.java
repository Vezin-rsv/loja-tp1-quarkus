package br.unitins.tp1.loja.dto.produto;

import java.time.LocalDate;

import br.unitins.tp1.loja.model.produto.Lote;

public record LoteResponseDTO(Long id, String codigo, Integer quantidade, LocalDate dataFabricacao, 
VentiladorResponseDTO ventilador) {
    public static LoteResponseDTO valueOf(Lote lote){
        return new LoteResponseDTO(
            lote.getId(), 
            lote.getCodigo(), 
            lote.getQuantidade(),
            lote.getDataFabricacao(),
            VentiladorResponseDTO.valueOf(lote.getVentilador())
        );
    }
}
