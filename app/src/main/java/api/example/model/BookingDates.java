package api.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates{
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    @JsonProperty
    private String checkin;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    @JsonProperty
    private String checkout;

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public String getCheckin() {
        return checkin;
    }
    public String getCheckout() {
        return checkout;
    }
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

}
