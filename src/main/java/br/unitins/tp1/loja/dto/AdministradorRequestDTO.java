package br.unitins.tp1.loja.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdministradorRequestDTO(
    @NotBlank(message = "Não pode ser nulo")
    @Size(max = 100, message = "O campo nome deve conter no máximo 60 caracteres")
    String nome,
    @NotBlank(message = "Não pode ser nulo")
    String setorResponsavel,
    @NotBlank(message = "Não pode ser nulo")
    String username,
    @NotBlank(message = "Não pode ser nulo")
    String enderecoEmail,
    @NotBlank(message = "Não pode ser nulo")
    String senha
    ) {
}
