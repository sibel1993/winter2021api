package pojo_tests;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequestWithPojo02 extends HerOkuAppBaseUrl {
    /*
    When
 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2

 	Then
 		Status code is 200
 		And response body is like {
 		{
    "firstname": "Mary",
    "lastname": "Smith",
    "totalprice": 647,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2016-02-05",
        "checkout": "2021-01-16"
    }
}

								  }
     */
    @Test
    public void get01(){
        //1)set the url
        spec.pathParams("first","booking",
                "second",2);
        //2)set expected data
        BookingDatePojo bookingDatePojo=new BookingDatePojo("2016-02-05","2021-01-25" );
        BookingPojo expectedPojo=new BookingPojo("Mary","Smith",647,false,bookingDatePojo);
        System.out.println(expectedPojo);
        //3)send the request
        Response response=given().contentType(ContentType.JSON).spec(spec).body(expectedPojo).when().post("/{first}/{second}");
        response.prettyPrint();
        //4)assert the output
        //1)use GSON
        BookingPojo actualPojo=response.as(BookingPojo.class);
        System.out.println(actualPojo);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedPojo.getFirstName(),actualPojo.getFirstName());
        assertEquals(expectedPojo.getLastName(),actualPojo.getLastName());
        assertEquals(expectedPojo.getTotalPrice(),actualPojo.getTotalPrice());
        assertEquals(expectedPojo.isDepositPaid(),actualPojo.isDepositPaid());
        assertEquals(expectedPojo.getBookingDates().getCheckIn(),actualPojo.getBookingDates().getCheckIn());
        assertEquals(expectedPojo.getBookingDates().getCheckOut(),actualPojo.getBookingDates().getCheckOut());
        //2)use object mapper
      BookingPojo actualPojo2=  JsonUtil.convertJsonToJava(response.asString(),BookingPojo.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedPojo.getFirstName(),actualPojo2.getFirstName());
        assertEquals(expectedPojo.getLastName(),actualPojo2.getLastName());
        assertEquals(expectedPojo.getTotalPrice(),actualPojo2.getTotalPrice());
        assertEquals(expectedPojo.isDepositPaid(),actualPojo2.isDepositPaid());
        assertEquals(expectedPojo.getBookingDates().getCheckIn(),actualPojo.getBookingDates().getCheckIn());
        assertEquals(expectedPojo.getBookingDates().getCheckOut(),actualPojo.getBookingDates().getCheckOut());





    }

}
