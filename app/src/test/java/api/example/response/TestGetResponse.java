package api.example.response;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Validating HTTP Response Status Code.
How to validate the Error Status Code
Validating Response Status Line.
 */
public class TestGetResponse {
    private static Logger LOG = LoggerFactory.getLogger(TestGetResponse.class);
    private  String baseUri ="https://restful-booker.herokuapp.com/booking";
    private RequestSpecification requestSpec;
    @BeforeClass (description = "add headers, set base uri")
    public void setupRequestSpec(){
        //curl -i https://restful-booker.herokuapp.com/booking/1
         requestSpec = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .setBaseUri(baseUri)
                .build();
    }
    @Test (description = "Status line should be 200 OK")
    public void testResponseStatusLine(){
        RestAssured.given()
                .spec(requestSpec)
                .get().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test()
    public void testResponseStatusCode(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(baseUri);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
    @Test (description = "verify headers")
    public void testResponseHeader(){
       Response response = RestAssured.given()
                .spec(requestSpec)
                .get();
        Headers headers = response.headers();
        for (Header header : headers){
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }
    @Test (description = "verify response body")
    public void testResponseBody(){
        Response response = RestAssured.given()
                .spec(requestSpec)
                .get();
       ResponseBody body= response.getBody();
      System.out.println("Response Body is: " + body.asString());

    }

}
