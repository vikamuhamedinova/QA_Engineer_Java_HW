import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void getStatus200() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .extract()
                .response();
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }

    @Test
    public void postRawStatus200() {
        String requestBody = "{\"test\": \"value\"}";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .and()
                .body("json.test", equalTo("value"))
                .extract()
                .response();
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }

    @Test
    public void postFormDataStatus200() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .extract()
                .response();
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }

    @Test
    public void putStatus200() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract()
                .response();
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }

    @Test
    public void patchStatus200() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract()
                .response();
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }

    @Test
    public void deleteStatus200() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract()
                .response();
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }
}
