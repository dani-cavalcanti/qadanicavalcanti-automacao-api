package domain;

import io.restassured.http.ContentType;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class ProductAuth extends BaseTest {

    public String authProd(){
        String token =
                given()
                        .body("{\n" +
                                "    \"username\": \"kminchelle\",\n" +
                                "    \"password\": \"0lelplR\"\n" +
                                "}")
                        .contentType(ContentType.JSON)
                        .when()
                        .post("auth/login")
                        .then()
                        .extract()
                        .path("token");

        return token;
    }
}
