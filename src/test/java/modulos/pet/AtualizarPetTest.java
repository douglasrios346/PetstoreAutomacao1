package modulos.pet;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import com.github.javafaker.Faker;
import testBase.TestBase;

public class AtualizarPetTest extends TestBase {

    @Test
    @DisplayName("Atualizar dados de um pet existente com sucesso - StatusCode 200")
    public void testAtualizarDadosDeUmPetExistenteComSucesso() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        int petId = 7;

        // Executar um PUT para atualizar os dados do pet
        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                        "  \"id\": " + petId + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 7,\n" +
                        "    \"name\": \"" + name + "\"\n" +
                        "  },\n" +
                        "  \"name\": \"" + name + "\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
        .when()
            .put("/pet/")
        .then()
            .statusCode(200);

        // Executar um GET para validar se os dados do pet foram inseridos
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/pet/" + petId)
        .then()
            .statusCode(200)
            .body("category.name", equalTo(name))
            .body("name", equalTo(name))
            .body("status", equalTo("sold"))
            .log().body();
    }

}



