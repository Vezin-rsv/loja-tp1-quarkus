package br.unitins.tp1.loja.service;

import br.unitins.tp1.loja.dto.usuario.UsuarioResponseDTO;

public interface JwtService {

    public String generateJwt(UsuarioResponseDTO dto);

}
