package br.unitins.tp1.loja.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO (
    @NotBlank(message = "Não pode ser nulo")
    String username, 
    @NotBlank(message = "Não pode ser nulo")
    String senha,
    @NotBlank(message = "Não pode ser nulo")
    Integer idPerfil
    ) {
    
}