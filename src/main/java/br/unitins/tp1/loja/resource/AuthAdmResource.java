package br.unitins.tp1.loja.resource;

import br.unitins.tp1.loja.dto.AuthRequestDTO;
import br.unitins.tp1.loja.dto.AdministradorResponseDTO;
import br.unitins.tp1.loja.model.Administrador;
import br.unitins.tp1.loja.service.HashService;
import br.unitins.tp1.loja.service.JwtService;
import br.unitins.tp1.loja.service.AdministradorService;
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
public class AuthAdmResource {

    @Inject
    HashService hashService;

    @Inject
    AdministradorService administradorService;

    @Inject
    JwtService jwtService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthRequestDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());

        Administrador administrador = administradorService.findByUsernameAndSenha(authDTO.username(), hash);

        if (administrador == null) {
            return Response.status(Status.NO_CONTENT)
                .entity("Administrador não encontrado").build();
        } 
        return Response.ok()
            .header("Authorization", jwtService.generateJwtAdm(AdministradorResponseDTO.valueOf(administrador)))
            .build();
        
    }
  
}
