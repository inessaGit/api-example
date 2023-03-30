package api.example.temp;

import api.example.BaseTestBooking;
import api.example.model.AuthToken;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BookingCreateAuthToken extends BaseTestBooking {

    @Test(description = "create auth token for booking app PUT /DELETE requests")
    public void testCreateAuthToken(){
        String token =AuthToken.createAuthToken();
        BaseTestBooking.logToAllureReport("Created new auth token for booking app"+token);
        Reporter.log("Created new auth token for booking app"+token);
    }
}
