package tests;

import domain.Product;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostAddProductTest extends BaseTest {
    private static String ADICIONA_PRODUTO = "products/add";

    @Test
    @DisplayName("Criação de produto com dados válidos")
    public void verificar_se_a_criacao_de_um_novo_produto_e_bem_sucedida() {
        Product novoProduto = new Product("Perfume Oil","Mega Discount, Impression of A...", 13, 8.4, 4.26, 65,"Impression of Acqua Di Gio","fragrances","https://i.dummyjson.com/data/products/11/thumnail.jpg");

        adicionaProduto(novoProduto)
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schemas/addProduct.json"));
    }

    @Test
    @DisplayName("Criação de produto com dados inválidos")
    public void verificar_se_a_criacao_de_um_novo_produto_com_dados_invalidos() {
        Product novoProduto = new Product(2,"", "a", "#", 4.26, 65,"Impression of Acqua Di Gio","fragrances","https://i.dummyjson.com/data/products/11/thumnail.jpg");

        adicionaProduto(novoProduto)
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schemas/addProduct.json"));
    }

    private ValidatableResponse adicionaProduto(Product novoProduto) {
        return given()
                .contentType(ContentType.JSON)
                .body(novoProduto)
                .when()
                .post(ADICIONA_PRODUTO)
                .then();
    }

}
