import json_model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class ApiTest {
    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void verifyApiStatusCodeTest() {
        given().when().get(API_URL).then()
                .assertThat().statusCode(200);
    }

    @Test
    public void verifyApiContentTypeTest() {
        given().when().get(API_URL).then()
                .assertThat()
                .header("content-type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void verifyApiBodyTest() {
        assertEquals(10, Arrays.stream(given().when().get(API_URL).as(User[].class)).count());
    }
}
