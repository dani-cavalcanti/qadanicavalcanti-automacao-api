/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tests;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class GetStatusTest extends BaseTest {

    private static final String ENDPOINT_VALIDO = "test";
    private static final String ENDPOINT_INVALIDO = "tests";

    @Test
    @DisplayName("Buscar o status da aplicação com url válida")
    public void Verificar_se_a_chamada_a_API_retorna_o_status_correto() {
        when()
                .get(ENDPOINT_VALIDO)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/status.json"));
    }



    @Test
    @DisplayName("Buscar o status da aplicação com url inválida")
    public void Verificar_o_comportamento_quando_a_chamada_a_API_falha() {
        when()
                .get(ENDPOINT_INVALIDO)
                .then().body(containsString("not found!"))
                .body(containsString("not found!"));
    }

}
