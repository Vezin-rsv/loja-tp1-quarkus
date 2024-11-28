package br.unitins.tp1.loja.dto.usuario;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record ClienteRequestDTO (
    @NotBlank(message = "Não pode ser nulo")
    Long idUsuario, 
    @NotBlank(message = "Não pode ser nulo")
    @Size(max = 100, message = "O campo nome deve conter no máximo 100 caracteres")
    String nome, 
    LocalDate dataNascimento, 
    @NotBlank(message = "Não pode ser nulo")
    String cpf
    ) {
    
}