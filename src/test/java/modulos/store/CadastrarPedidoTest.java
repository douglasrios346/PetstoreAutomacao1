package modulos.store;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import dataFactory.CadastroPedidoDataFactory;
import testBase.TestBase;

public class    CadastrarPedidoTest extends TestBase  {
    @Test
    @DisplayName("Deve cadastrar novo pedido de pet com sucesso - StatusCode 200")
    public void testCadastrarNovoPedidoDePetComSucesso() {

        // Executar um POST para cadastrar um novo pedido de pet
        given()
            .contentType(ContentType.JSON)
            .body(CadastroPedidoDataFactory.setBody())
        .when()
            .post("/store/order")
        .then()
            .body("id", equalTo(1))
            .body("status", equalTo("placed"))
            .statusCode(200)
            .log().body();
    }
    @Test
    @DisplayName("Cadastrar novo pedido de pet com erro - StatusCode 400")
    public void testCadastrarNovoPedidoDePetComErro() {

        // Executar um POST para cadastrar um novo pedido de pet com erro
        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                        "  \"id\": ,\n" +
                        "  \"petId\": 99,\n" +
                        "  \"quantity\": 99,\n" +
                        "  \"shipDate\": \"2024-03-08T22:32:11.465Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
        .when()
            .post("/store/order")
        .then()
            .body("message", equalTo("bad input"))
            .statusCode(400)
            .log().body();
    }
}


