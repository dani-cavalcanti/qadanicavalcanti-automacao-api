package tests;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;

public class GetProductsTest extends BaseTest {

    private static final String ENDPOINT_VALIDO = "products";
    private static final String ENDPOINT_INVALIDO = "produto";

    @Test
    @DisplayName("Buscar todos os produtos com url válida")
    public void verificar_se_a_busca_de_todos_os_produtos_retorna_a_lista_completa_de_produtos() {
        when()
                .get(ENDPOINT_VALIDO)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/products.json"));
    }

    @Test
    @DisplayName("Buscar todos os produtos com url inválida")
    public void verificar_o_comportamento_quando_a_busca_de_todos_os_produtos_falha() {
        when()
                .get(ENDPOINT_INVALIDO)
                .then().body(containsString("not found!"))
                .body(containsString("not found!"));
    }



}
