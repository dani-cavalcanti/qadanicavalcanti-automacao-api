package tests;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;

public class GetBuscaUsersTest extends BaseTest {
    private static final String ENDPOINT_VALIDO = "users";
    private static final String ENDPOINT_INVALIDO = "use";

    @Test
    @DisplayName("Buscar usuário para autenticação com url válida")
    public void buscar_usuarios_para_autenticacao_com_url_valida() {
        when()
                .get(ENDPOINT_VALIDO)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/users.json"));
    }

    @Test
    @DisplayName("Buscar usuário para autenticação com url inválida")
    public void buscar_usuarios_para_autenticacao_com_url_invalida() {
        when()
                .get(ENDPOINT_INVALIDO)
                .then()
                .body(containsString("not found!"));
    }

}
