package br.unitins.tp1.loja.dto.pagamento;

import br.unitins.tp1.loja.model.pagamento.Cartao;
import br.unitins.tp1.loja.model.pagamento.EscolhaTipoCartao;

public record CartaoResponseDTO(
    Long id,
    String numeroCartao,
    String nomeTitular,
    String validade,
    String codigoSeguranca,
    EscolhaTipoCartao tipo
) {
    public static CartaoResponseDTO valueOf(Cartao cartao) {
        return new CartaoResponseDTO(
            cartao.getId(),
            cartao.getNumeroCartao(),
            cartao.getNomeTitular(),
            cartao.getValidade(),
            cartao.getCodigoSeguranca(),
            cartao.getTipo());
    }
}
