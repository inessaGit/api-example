package api.example;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class GET_User {
    private static Logger LOG = LoggerFactory.getLogger(GET_User.class);
    private String baseUrl = "https://reqres.in/api";

    @Test
    public void testGetUserId2() {
        LOG.info("Step - 1 : Send GET Request");
        String url = baseUrl+"/users/2";
        Response response = RestAssured.given().get(url).andReturn();

        LOG.info("Step - 2 : Print the JSON response body");
        response.getBody().prettyPrint();

        LOG.info("Step - 3 : Assert StatusCode = 200");
        Assert.assertEquals(response.getStatusCode(), 200, "http status code");

        LOG.info("Step - 4 : Verify that the response contains id = 2");
        Integer userId = response.getBody().jsonPath().getInt("data.id");
        Assert.assertTrue(userId==2);
    }

}
