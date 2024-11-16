package br.unitins.tp1.loja.dto;

import java.time.LocalDate;
import br.unitins.tp1.loja.model.Usuario;

public record UsuarioResponseDTO(Long id, String nome, String cpf, LocalDate dataNascimento, String nomeImagem, String username, 
String enderecoEmail, String senha) {
    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(), 
            usuario.getNome(), 
            usuario.getCpf(),
            usuario.getDataNascimento(),
            usuario.getNomeImagem(),
            usuario.getUsername(),
            usuario.getEnderecoEmail(),
            usuario.getSenha()
        );
    }
}
