package br.unitins.tp1.loja.resource;

import br.unitins.tp1.loja.dto.usuario.AuthRequestDTO;
import br.unitins.tp1.loja.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.loja.model.usuario.Cliente;
import br.unitins.tp1.loja.model.usuario.Usuario;
import br.unitins.tp1.loja.service.HashService;
import br.unitins.tp1.loja.service.JwtService;
import br.unitins.tp1.loja.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JwtService jwtService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthRequestDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());

        Usuario usuario = usuarioService.findByUsernameAndSenha(authDTO.username(), hash);

        if (usuario == null) {
            return Response.status(Status.NO_CONTENT)
                .entity("Usuario não encontrado").build();
        } 
        return Response.ok()
            .header("Authorization", jwtService.generateJwt(UsuarioResponseDTO.valueOf(usuario)))
            .build();
        
    }
  
}
