package br.unitins.tp1.loja.resource;


import java.io.IOException;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.tp1.loja.dto.UsuarioRequestDTO;
import br.unitins.tp1.loja.dto.UsuarioResponseDTO;
import br.unitins.tp1.loja.form.UsuarioImageForm;
import br.unitins.tp1.loja.service.FileService;
import br.unitins.tp1.loja.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    public UsuarioService usuarioService;

    @Inject
    public FileService usuarioFileService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(UsuarioResponseDTO.valueOf(usuarioService.findById(id))).build();
    }

    @GET
    @Path("/search/{username}")
    public Response findByUsername(@PathParam("username") String username) {
        return Response.ok(UsuarioResponseDTO.valueOf(usuarioService.findByUsername(username))).build();
    }

    @GET
    @Path("/search/{usernameAndSenha}")
    public Response findByUsernameAndSenha(@PathParam("usernameAndSenha") String username, String Senha) {
        return Response.ok(UsuarioResponseDTO.valueOf(usuarioService.findByUsernameAndSenha(username, Senha))).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(usuarioService.
                    findAll().
                    stream().
                    map(o -> UsuarioResponseDTO.valueOf(o)).
                    toList()).build();
        
    }

    // @POST
    // public Response create(@Valid UsuarioRequestDTO dto) {
    //     return Response.status(Status.CREATED).entity(UsuarioResponseDTO.valueOf(usuarioService.create(dto))).build();
    // }

    // @PUT
    // @Path("/{id}")
    // public Response update(@PathParam("id") Long id, @Valid UsuarioRequestDTO dto) {
    //     usuarioService.update(id, dto);
    //     return Response.noContent().build();
    // }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/upload/imagem")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImage(@PathParam("id") Long id, @MultipartForm UsuarioImageForm form) {

        try {
            String nomeImagem = usuarioFileService.save(form.getNomeImagem(), form.getImagem());

            usuarioService.updateNomeImagem(id, nomeImagem);

        } catch (IOException e) {
           Response.status(500).build();
        }
        return Response.noContent().build();
    }


    @GET
    @Path("/download/imagem/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadImage(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = 
            Response.ok(usuarioFileService.find(nomeImagem));
            response.header("Content-Disposition", "attachment; filename="+nomeImagem);
            return response.build();
    }
    
}
