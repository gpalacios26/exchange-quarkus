package com.gpc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExchangeResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/D:/Aplicaciones/Git/exchange")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}