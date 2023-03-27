package api.example.booking;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
given().
          param("firstName", "John").
          param("lastName", "Doe").
  when().
          get("/greet").
  then().
          body("greeting", equalTo("John Doe"));
 */

public class GET_BookingIds {

    private Logger LOG = LoggerFactory.getLogger(GET_BookingIds.class);
    private RequestSpecification requestSpec;
    private Response response;
    private ResponseBody responseBody;
    private  String baseUri = "https://restful-booker.herokuapp.com/booking";

    @BeforeClass
    public void setup(){
       response= RestAssured.given().with()
                .header("Accept","application/json")
                .get(baseUri);
       responseBody = response.getBody();
    }

    @Description("")
    @Test(description="assert status code =200")
    public void testGetBookingIdsStatusCode(){
      response.then().assertThat()
              .statusCode(200);
    }

    @Description("")
    @Test(description="assert response has array of objects")
    public void testGetBookingIdsBody(){
//Array of objects that contain unique booking IDs
        response.then().body("object", Matchers.notNullValue());
        response.then()
                .assertThat()
                .body("object.bookingid", Matchers.notNullValue());
    }
    @Test  (description = "log rest assured GET request with parameters ")
    public void whenLogRequest_thenOK() {
        RestAssured.given().log().all()
                .param("firstname","sally")
                .param("lastname","brown")
                .when().get(baseUri)
                .then().statusCode(200);
    }
    @Test  (description = "log rest assured GET request  ")
    public void logWithRestAssured() {
        RestAssured.get(baseUri).then().log().body();
        RestAssured.get(baseUri).then().log().ifError();
        RestAssured.get(baseUri).then().log().all(); //including status line, headers and cookies

        RestAssured.get(baseUri).then().log().status();
        RestAssured.get(baseUri).then().log().headers();
        RestAssured.get(baseUri).then().log().cookies();
        RestAssured.get(baseUri).then().log().ifStatusCodeIsEqualTo(302);
        RestAssured.get(baseUri).then().log().ifValidationFails();





    }
}
