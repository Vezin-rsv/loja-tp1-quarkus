package br.unitins.tp1.loja.dto;

import br.unitins.tp1.loja.model.Administrador;

public record AdministradorResponseDTO(Long id, String nome, String setorResponsavel, String username, 
String enderecoEmail, String senha) {
    public static AdministradorResponseDTO valueOf(Administrador administrador){
        return new AdministradorResponseDTO(
            administrador.getId(),
            administrador.getNome(),
            administrador.getSetorResponsavel(),
            administrador.getUsername(),
            administrador.getEnderecoEmail(),
            administrador.getSenha()
        );
    }
}
