package api.example.booking;

import api.example.model.BookingDates;
import api.example.model.BookingDetails;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
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
*/

public class GET_Booking {
    private static Logger LOG = LoggerFactory.getLogger(GET_Booking.class);
    private String baseUri = "https://restful-booker.herokuapp.com/booking";
    private RequestSpecification requestSpec;
    private Response response;
    private ResponseBody responseBody ;
   @BeforeClass(description = "add headers, set base uri, add parameter")
    public void setupRequestSpec() {
        //curl -i https://restful-booker.herokuapp.com/booking/1
        requestSpec = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("accept","application/json")
                .setBaseUri(baseUri)
                .build();
        response = RestAssured.given()
                .spec(requestSpec)
                .get("/1").andReturn();
        responseBody = response.getBody();
    }
    @Test(description = "send get request without specifying headers; assert status code 200")
    public void sendGetRequest() {
        //curl -i https://restful-booker.herokuapp.com/booking/1
        //HttpStatus.OK.value()
        RestAssured.when().get(baseUri+"/1").then().assertThat().statusCode(200);
    }
    @Test(description = "send get request with headers;")
    public void sendGetRequest2() {
        //curl -i https://restful-booker.herokuapp.com/booking/1
        RestAssured
                .with()
                .header("Accept","application/json")
                .get(baseUri+"/1")
                .then()
                .assertThat()
                .statusLine("HTTP/1.1 200 OK");
    }

    @Description("verify response") //allure report
    @Test(description="test get booking by id ")
    public void testGetById(){
       // response.then().body("bookingdates.checkin", Matchers.notNullValue());
    }
}
