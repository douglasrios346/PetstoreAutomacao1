package modulos.pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBase.TestBase;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PesquisarPetTest extends TestBase {
    @Test
    @DisplayName("Deve pesquisar por um pet inexistente ")
    public void testPesquisarPorUmPetInexistenteComSucesso() {
        int petId = 112;

        // Executar um GET para validar se os dados do pet foram inseridos
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/pet/" + petId)
        .then()
            .body("message", equalTo("Pet not found"))
            .statusCode(404)
            .log().body();
    }
    @Test
    @DisplayName("Deve pesquisar por pets com status pending")
    public void testPesquisarPorPetsComStatusPendente() {

        //Pesquisar por pets com status pending
        Response response = given()
            .contentType(ContentType.JSON)
            .queryParam("status", "pending")
        .when()
            .get("/pet/findByStatus")
        .then()
            .statusCode(200)
            .log().body()
            .extract().response();
    }
}

