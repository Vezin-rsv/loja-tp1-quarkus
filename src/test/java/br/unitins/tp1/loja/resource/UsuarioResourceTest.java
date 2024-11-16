package br.unitins.tp1.loja.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.loja.dto.UsuarioRequestDTO;
import br.unitins.tp1.loja.model.Usuario;
import br.unitins.tp1.loja.service.UsuarioService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class UsuarioResourceTest {
    @Inject
    public UsuarioService cService;
   
    @Test
    public void testFindAll(){
        given()
            .when().get("/usuarios")
            .then().statusCode(200);
    }

    @Test
    public void testCreate(){
        UsuarioRequestDTO dto = new UsuarioRequestDTO("Raquele", "11111111111", 
                                                    LocalDate.of(2005, 9, 22), 
                                            "raqueles", "quel@gmail.com", "123456");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when()
                .post("/usuarios")
            .then()
                .statusCode(201)
                .body("id", notNullValue(),
                  "nome", is("Raquele"),
                  "cpf", is("11111111111"),
                  "dataNascimento", is("2005-09-22"), 
                  "username", is("raqueles"),
                  "enderecoEmail", is("quel@gmail.com"), 
                  "senha", is("123456"));
        
        // removendo o dado que foi inserido
         cService.delete(cService.findByCpf("11111111111").getId());
    }

    @Test
    public void testUpdate() {
        // inserindo dado para alteracao (evitando a manipulacao de dados)
        UsuarioRequestDTO dto = 
        new UsuarioRequestDTO("teste", "77777777777", LocalDate.of(2000, 9, 15), 
        "loll", "teste@gmail.com", "987654");
        
        long id = cService.create(dto).getId();

        UsuarioRequestDTO novoDto = 
            new UsuarioRequestDTO("teste rodando", "77777777777", LocalDate.of(2000, 9, 15), 
            "loll", "teste@gmail.com", "987654");

        given()
        .contentType(ContentType.JSON)
        .body(novoDto)
        .when()
            .put("/usuarios/"+id)
        .then()
            .statusCode(204);

        Usuario c = cService.findById(id);

        assertEquals(c.getUsername(), "loll");

        // removendo o dado que foi inserido
        cService.delete(cService.findByCpf("77777777777").getId());

    }

    @Test
    public void testDelete() {
        // inserindo dado para alteracao (evitando a manipulacao de dados)
        UsuarioRequestDTO dto = 
        new UsuarioRequestDTO("teste", "77777777777", LocalDate.of(2000, 9, 15), 
        "loll", "teste@gmail.com", "987654");
        
        long id = cService.create(dto).getId();

        given()
        .when()
            .delete("/usuarios/"+id)
        .then()
            .statusCode(204);

        // verificando se foi apagado no banco de dados
        Usuario c = cService.findById(id);
        assertNull(c);
    
    }
}
