package br.unitins.tp1.loja.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRequestDTO (
    @NotBlank(message = "Não pode ser nulo")
    Long idUsuario, 
    @NotBlank(message = "Não pode ser nulo")
    String setorResponsavel
    ) {
    
}