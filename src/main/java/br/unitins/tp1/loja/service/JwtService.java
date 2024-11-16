package br.unitins.tp1.loja.service;

import br.unitins.tp1.loja.dto.UsuarioResponseDTO;
import br.unitins.tp1.loja.dto.AdministradorResponseDTO;

public interface JwtService {

    public String generateJwtUser(UsuarioResponseDTO dto);

    public String generateJwtAdm(AdministradorResponseDTO dto);

}
