package br.unitins.tp1.loja.dto.usuario;

import java.time.LocalDate;

import br.unitins.tp1.loja.model.usuario.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    LocalDate dataNascimento,
    String cpf,
    UsuarioResponseDTO usuario
) {
    
    public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getDataNascimento(),
            cliente.getCpf(),
            UsuarioResponseDTO.valueOf(cliente.getUsuario()));
    }
}