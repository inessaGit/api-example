package api.example.booking;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GET_BookingWithParameters {
    private String baseUri ="https://restful-booker.herokuapp.com";


    @BeforeClass
      public void setup()
    {

    }

    @Test(description = "Get booking with request parameter ")
    public void getBookingIdWithRequestParams(){
    RestAssured.given()
            .baseUri(baseUri)
            .with()
            .header("Accept","application/json")
            .param("firstname","sally")
            .param("lastname","brown")
            .when()
            .get()
            .then()
            ;

    }
    @Test(description = "Get booking with path parameter ")
    public void getBookingIdWithPathParams(){
      RestAssured.given()
              .baseUri(baseUri)
              .basePath("{resourcePath}")
              .pathParam("resourcePath", "booking")
              .when()
              .get()
              .then()
              .assertThat().statusCode(200);
    }
}
