package br.unitins.tp1.loja.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import br.unitins.tp1.loja.dto.UsuarioResponseDTO;
import br.unitins.tp1.loja.dto.AdministradorResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class JwtServiceImpl implements JwtService{
    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwtUser(UsuarioResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        roles.add(dto.username());

        return Jwt.issuer("unitins-jwt")
            .subject(dto.username())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }

    @Override
    public String generateJwtAdm(AdministradorResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
        roles.add(dto.username());

        return Jwt.issuer("unitins-jwt")
            .subject(dto.username())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }
}
