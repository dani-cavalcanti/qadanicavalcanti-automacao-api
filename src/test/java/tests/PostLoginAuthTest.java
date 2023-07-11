package tests;

import domain.LoginAuth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;


public class PostLoginAuthTest extends BaseTest {
    private static final String LOGIN_AUTH = "auth/login";

    @Test
    @DisplayName("Criação de token para autenticação com dados válidos")
    public void Verificar_se_a_criacao_do_token_e_bem_sucedida() {
        LoginAuth login = new LoginAuth("kminchelle","0lelplR");

        geraToken(login)
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schemas/loginAuth.json"));
    }

    @Test
    @DisplayName("Criação de token para autenticação com dados inválidos")
    public void Verificar_o_comportamento_quando_a_criacao_do_token_falha() {
        LoginAuth login = new LoginAuth("","");

        geraToken(login)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(matchesJsonSchemaInClasspath("schemas/error400.json"))
                .body("message", is("Invalid credentials"));
    }

    private ValidatableResponse geraToken (LoginAuth login) {
        return given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post(LOGIN_AUTH)
                .then();
    }
}
