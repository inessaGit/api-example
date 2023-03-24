package api.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_Register {
    private static Logger LOG = LoggerFactory.getLogger(POST_Register.class);
    private String baseUrl = "https://reqres.in/api";

    @Test(description ="Register unsuccessful: error missing password")
    public void testPOST() {
        LOG.info("Step - 1 : Send POST Request");
        String url = baseUrl+"/register";
        String body = "{\"email\": \"sydney@fife\"}";

        Response response = RestAssured.given()
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .body(body)
                .post(url)
                .andReturn();

        LOG.info("Step - 3 : Assert StatusCode = 400");
        Assert.assertEquals(response.getStatusCode(), 400, "http status code");
        LOG.info("Step - 4 : Print the response message");
        response.getBody().prettyPrint();

        LOG.info("Step - 5 : Assert error message");
        String expected="Missing password";
        String actual = response.getBody().jsonPath().getString("error");
        Assert.assertEquals(actual,expected);
    }
}
