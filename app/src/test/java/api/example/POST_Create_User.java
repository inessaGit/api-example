package api.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_Create_User {
    private static Logger LOG = LoggerFactory.getLogger(POST_Create_User.class);
    private String baseUrl = "https://reqres.in/api";

    @Test(description ="POST Create user: 201")
    public void testPOST() {
        LOG.info("Step - 1 : Send POST Request");
        String url = baseUrl+"/users";
        String body = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        Response response = RestAssured.given()
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .body(body)
                .post(url)
                .andReturn();

        LOG.info("Step - 3 : Assert StatusCode = 201 created success");
        Assert.assertEquals(response.getStatusCode(), 201, "http status code");

        LOG.info("Step - 4 : Print the response message");
        response.getBody().prettyPrint();

        LOG.info("Step - 5 : Assert id created");
        String expected="morpheus";
        String actual = response.getBody().jsonPath().getString("name");
        Assert.assertEquals(actual,expected);
    }

}
