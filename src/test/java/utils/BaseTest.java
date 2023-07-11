package utils;

import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

public class BaseTest {
    @BeforeClass
    public static void setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://dummyjson.com/";

    }


}
