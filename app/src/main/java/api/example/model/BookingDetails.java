package api.example.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-CreateBooking
 */

public class BookingDetails {

    public BookingDetails(String firstname, String lastname, int totalprice,
                          boolean depositpaid,
                          String additionalneeds){
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice= totalprice;
        this.depositpaid=depositpaid;
        this.additionalneeds = additionalneeds;
    }

    @JsonProperty
    private BookingDates bookingdates;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private int totalprice;
    @JsonProperty
    private Boolean depositpaid;
    @JsonProperty
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public Boolean getDepositpaid() {
        return depositpaid;
    }
    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
}