package com.redhat.quarkushackfest.team1;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ChatBotResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/chatbot")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}