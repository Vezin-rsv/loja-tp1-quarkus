package br.unitins.tp1.loja.validation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException>{

    @Override
    public Response toResponse(ValidationException exception){
        ValidationError error = new ValidationError("400", "erro de validação");
        error.addFieldError(exception.getFieldName(), exception.getMessage());
        
        return Response.status(400).entity(error).build();
    }

    
}
