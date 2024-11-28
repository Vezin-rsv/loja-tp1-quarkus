package br.unitins.tp1.loja.dto.pagamento;

import br.unitins.tp1.loja.model.pagamento.Boleto;

public record BoletoResponseDTO(
    Long id,
    String codigoBarras,
    Double valor
){
    public static BoletoResponseDTO valueOf(Boleto boleto) {
        return new BoletoResponseDTO(
            boleto.getId(),
            boleto.getCodigoBarras(),
            boleto.getValor());
    }
}
