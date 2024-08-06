package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testdata.Booking;
import testdata.BookingDates;
import testdata.BookingID;

import static io.restassured.RestAssured.*;

public class TestRequestWithLombokBody {

    @Test
    public void testRequestLombok() {

        BookingDates bookingDate = new BookingDates("2024-01-01","2024-01-24");
        Booking booking = new Booking("Ion", "Bob", 150, false, bookingDate, "Dinner");

        Response response = given().
                contentType(ContentType.JSON).
                body(booking).
                post("https://restful-booker.herokuapp.com/booking").
                then().extract().response();

        System.out.println(response.asString());

       BookingID bookingID = response.as(BookingID.class);
        System.out.println(bookingID.toString());

        System.out.println(booking.toString());
        System.out.println(bookingID.getBooking().toString());
        System.out.println(bookingID.getBookingid());

    }
}
