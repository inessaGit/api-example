package api.example.booking;

import api.example.BaseTestBooking;
import api.example.model.AuthToken;
import api.example.model.BookingDates;
import api.example.model.BookingDetails;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PUT_Booking extends BaseTestBooking {
    private BookingDetails booking ;
    private Response response;
    private Response responsePUT ;
    private ResponseBody responseBody;
    int bookingId;

    @BeforeClass
    public void setup(){
        //create POJO
        booking = new BookingDetails("inessa","last name",
                150,true,
                "breakfast lunch");
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2018-01-06");
        booking.setBookingdates( bookingDates);
    }

    @Test(description = "send POST")
    public void sendPOST(){
       response= RestAssured.given()
                .with()
                .header("Content-Type","application/json")
                .spec(requestSpec)
                .when()
                .body(booking)
                .post("/booking");
       responseBody = response.getBody();
      // System.out.println(response.prettyPrint());
        bookingId =responseBody.jsonPath().get("bookingid");
       System.out.println("created new booking id:"+bookingId);
        BaseTestBooking.logToAllureReport("New Booking ID created is : "+bookingId);

    }

    @Test(dependsOnMethods = {"sendPOST"},description = "send PUT")
    public void sendPUT(){
        BookingDates newDates = new BookingDates();
        newDates.setCheckin("2023-02-03");
        newDates.setCheckout("2023-02-09");
        booking.setBookingdates(newDates);
        String newAuthToken = AuthToken.createAuthToken();

        responsePUT = RestAssured.given()
                 .spec(requestSpec)
                 .with()
                 .header("Content-Type","application/json")
                 .header("Accept","application/json")
                 .cookie("token",newAuthToken)
                // .pathParam("id",bookingId)
                 .when()
                 .body(booking)
                 .put("/booking/"+bookingId)
                 .andReturn();
        System.out.println(responsePUT.prettyPrint());
    }

    @Test(dependsOnMethods = {"sendPOST","sendPUT"},description = "assert status code")
    public void assertStatusCodeAfterPut(){
        responsePUT.then().assertThat().statusCode(200);
    }

   @Test(dependsOnMethods = {"sendPOST","sendPUT"},description = "assert checking date changed after PUT")
    public  void assertCheckinDateChanged(){
       //System.out.println("===========");
       String checkin = responsePUT.getBody().jsonPath().getString("bookingdates.checkin");
      System.out.println("After PUT request checkin date:"+checkin);
       Assert.assertTrue(checkin.equals("2023-02-03"));
    }
    @Test(dependsOnMethods = {"sendPOST","sendPUT"},description = "assert checkout date changed after PUT")
    public void assertCheckoutDateChanged(){
        String checkout = responsePUT.getBody().jsonPath().getString("bookingdates.checkout");
        System.out.println("After PUT request checkout date:"+checkout);
        Assert.assertTrue(checkout.equals("2023-02-09"));
    }
}
