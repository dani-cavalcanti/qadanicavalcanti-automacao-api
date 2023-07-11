package tests;

import domain.ProductAuth;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class GetAuthProdTest extends BaseTest {
    private static final String AUTHPRODUCTS = "auth/products";
    private static final String TOKEN = new ProductAuth().authProd();
    private static final String TOKEN401 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZyIsImlhdCI6MTY4ODkzNTQ1MiwiZXhwIjoxNjg4OTM5MDUyfQ.B0tXm-r9kpasu0-70SSv_0nIikUpMoIfLX8wTk4v9eo";
    private static final String TOKEN403 = "";

    @Test
    @DisplayName("Buscar produtos com autenticação com token válido")
    public void Verificar_se_a_busca_de_produtos_autenticada_retorna_os_produtos_corretos(){
        buscaProdutos()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schemas/productAuth.json"));
    }

    @Test
    @DisplayName("Buscar produtos com autenticação com token inválido")
    public void Verificar_o_comportamento_quando_a_busca_de_produtos_autenticada_falha_erro_401(){
        buscaProdutos401()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body(matchesJsonSchemaInClasspath("schemas/error401.json"))
                .body("message", is("Invalid/Expired Token!"));
    }

    @Test
    @DisplayName("Buscar produtos com autenticação sem token")
    public void Verificar_o_comportamento_quando_a_busca_de_produtos_autenticada_falha_erro_403(){
        buscaProdutos403()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .body(matchesJsonSchemaInClasspath("schemas/error403.json"))
                .body("message", is("Authentication Problem"));
    }

    private ValidatableResponse buscaProdutos (){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN).
                when().
                get(AUTHPRODUCTS).
                then();

    }

    private ValidatableResponse buscaProdutos401 (){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN401).
                when().
                get(AUTHPRODUCTS).
                then();

    }

    private ValidatableResponse buscaProdutos403 (){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN403).
                when().
                get(AUTHPRODUCTS).
                then();

    }
}
