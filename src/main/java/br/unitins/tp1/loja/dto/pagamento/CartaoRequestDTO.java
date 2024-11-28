package br.unitins.tp1.loja.dto.pagamento;

import jakarta.validation.constraints.NotBlank;

public record CartaoRequestDTO(
    @NotBlank(message = "O número do cartão deve ser informado")
    String numeroCartao,
    @NotBlank(message = "O nome do titular deve ser informado")
    String nomeTitular,
    @NotBlank(message = "A validade deve ser informada")
    String validade,
    @NotBlank(message = "O código de segurança deve ser informado")
    String codigoSeguranca,
    Long idEscolhaTipoCartao
) {
    
}
