package br.unitins.tp1.loja.resource;


import java.io.IOException;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.tp1.loja.dto.produto.VentiladorRequestDTO;
import br.unitins.tp1.loja.dto.produto.VentiladorResponseDTO;
import br.unitins.tp1.loja.form.VentiladorImageForm;
import br.unitins.tp1.loja.service.FileService;
import br.unitins.tp1.loja.service.VentiladorService;
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

@Path("/ventiladores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VentiladorResource {

    @Inject
    public VentiladorService ventiladorService;

    @Inject
    public FileService ventiladorFileService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(VentiladorResponseDTO.valueOf(ventiladorService.findById(id))).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(ventiladorService.findByNome(nome).
                                    stream().
                                    map(o -> VentiladorResponseDTO.valueOf(o)).
                                    toList()).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(ventiladorService.
                    findAll().
                    stream().
                    map(o -> VentiladorResponseDTO.valueOf(o)).
                    toList()).build();
        
    }

    @POST
    public Response create(@Valid VentiladorRequestDTO dto) {
        return Response.status(Status.CREATED).entity(VentiladorResponseDTO.valueOf(ventiladorService.create(dto))).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid VentiladorRequestDTO dto) {
        ventiladorService.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        ventiladorService.delete(id);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/upload/imagem")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImage(@PathParam("id") Long id, @MultipartForm VentiladorImageForm form) {

        try {
            String nomeImagem = ventiladorFileService.save(form.getNomeImagem(), form.getImagem());

            ventiladorService.updateNomeImagem(id, nomeImagem);

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
            Response.ok(ventiladorFileService.find(nomeImagem));
            response.header("Content-Disposition", "attachment; filename="+nomeImagem);
            return response.build();
    }
    
}
