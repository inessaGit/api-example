package api.example.booking;

import api.example.BaseTest;
import api.example.model.BookingDates;
import api.example.model.BookingDetails;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POST_Booking {

    private static Logger LOG = LoggerFactory.getLogger(POST_Booking.class);
    private String baseUri = "https://restful-booker.herokuapp.com/booking";
    private RequestSpecification requestSpec;
    private Response response;
    private ResponseBody responseBody ;
 private BookingDetails booking ;


    @BeforeClass(description = "add headers, set base uri")
    public void setupRequestSpec(){
        //curl -i https://restful-booker.herokuapp.com/booking/1
        requestSpec = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("accept","application/json")
                .setBaseUri(baseUri)
                .build();

         booking = new BookingDetails("inessa","last name",
                150,true,
                "breakfast lunch");
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2018-01-06");
        booking.setBookingdates( bookingDates);

        response = RestAssured.given()
                .spec(requestSpec)
                .body(booking).post(baseUri).andReturn();
        responseBody = response.getBody();
    }

    @Description("verify response status code") //allure report
    @Test(description = "verify response status code") //tesng report
    public void testResponseStatusCode(){
        Assert.assertEquals(response.getStatusCode(), 200, "http response status code");
    }
    @Description("verify response body:booking id") //allure report
    @Test(description = "verify response body")
    public void testResponseBody(){
        System.out.println("Response Body is: " + responseBody.prettyPrint());
        BaseTest.logToAllureReport("Response Body is: " + responseBody.prettyPrint());

         int bookingId = responseBody.jsonPath().getInt("bookingid");
         Assert.assertTrue(bookingId!=0);
    }

    @Description("verify response body") //allure report
    @Test(description = "verify response body")
    public void testResponseBody2(){
        String booking = responseBody.jsonPath().getString("booking");
        String bookingFirstName= responseBody.jsonPath().getString("booking.firstname");
        System.out.println(booking) ;

        Assert.assertTrue(bookingFirstName.equals("inessa"));
    }
}
