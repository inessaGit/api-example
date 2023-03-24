package api.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_Login_Success {
    private static Logger LOG = LoggerFactory.getLogger(POST_Login_Success.class);
    private String baseUrl = "https://reqres.in/api";

    @Test(description ="Login successful:token generated")
    public void testPOSTLoginSuccess() {
        LOG.info("Step - 1 : Send POST Request");
        String url = baseUrl+"/login";
        String body = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";
       // String body = "{email: eve.holt@reqres.in,password: cityslicka}";

        Response response = RestAssured.given()
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .body(body)
                .post(url)
                .andReturn();
        LOG.info("Step - 2 : Assert StatusCode = 200");
        Assert.assertEquals(response.getStatusCode(), 200, "http status code");
        LOG.info("Step - 3 : Print the response message");
        response.getBody().prettyPrint();

        LOG.info("Step - 5 : Assert token generated");
        String token = response.getBody().jsonPath().getString("token");
        String expected="QpwL5tke4Pnpja7X4";
        Assert.assertEquals(token,expected);
    }
}
