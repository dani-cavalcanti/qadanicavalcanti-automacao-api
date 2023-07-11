package tests;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class GetProductIdTest extends BaseTest {
    private static final String ENDPOINT_VALIDO = "products/";

    @Test
    @DisplayName("Buscar apenas um produto por ID com Id válido")
    public void verificar_se_a_busca_de_um_produto_por_ID_retorna_o_produto_correto() {
                when()
                .get(ENDPOINT_VALIDO + 1)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/productId.json"));
    }

    @Test
    @DisplayName("Buscar apenas um produto por ID com Id inválido")
    public void verificar_o_comportamento_da_busca_de_um_produto_com_um_ID_inexistente () {
                when()
                .get(ENDPOINT_VALIDO + 0)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body(matchesJsonSchemaInClasspath("schemas/error404.json"))
                        .body("message", is("Product with id '0' not found"));
    }
}
