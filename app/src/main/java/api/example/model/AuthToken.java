package api.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

/*
https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth-CreateToken
Creates a new auth token to use for access to the PUT and DELETE /booking

 */
public class AuthToken {

    private static final String username="admin";
    private static final String password ="password123";


    public static String createAuthToken() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",username);
        jsonObject.put("password",password);
        String token ="";
        String baseUri ="https://restful-booker.herokuapp.com/auth";

        ResponseBody responseBody =RestAssured.given()
                .baseUri(baseUri)
                .with()
                .header("Content-Type","application/json")
                .when()
                .body(jsonObject.toJSONString())
                .post()
                .getBody();

        token=responseBody.jsonPath().getString("token");
        System.out.println("Auth token="+token);
        return token;
    }



}
