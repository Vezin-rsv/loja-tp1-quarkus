package br.unitins.tp1.loja.dto.usuario;

import br.unitins.tp1.loja.model.usuario.Funcionario;

public record FuncionarioResponseDTO(
    Long id,
    String setorResponsavel,
    UsuarioResponseDTO usuario
) {
    
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getSetorResponsavel(),
            UsuarioResponseDTO.valueOf(funcionario.getUsuario()));
    }
}