package api.example.booking;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
    @Test  (description = "Assert result set has specific booking id retrieved on GET")
    public void logWithRestAssured() {
        JsonPath jsonPath = responseBody.jsonPath();
        //jsonPath.prettyPrint();
        List<Integer> bookingid=jsonPath.get("bookingid");
        System.out.println(bookingid); //array of ints

        //Mathcers.contains (4197) fail because it is not exact match for all items
        MatcherAssert.assertThat(bookingid,Matchers.hasItem(4197));
    }

    @Test(description = "Assert bookings ids retrieved on GET")
    public void testBookingIdsNotEmpty(){
        JsonPath jsonPath = responseBody.jsonPath();
        List<Integer> bookingIds =jsonPath.get("bookingid");
        MatcherAssert.assertThat(bookingIds,Matchers.not(Matchers.empty()));
    }
}
