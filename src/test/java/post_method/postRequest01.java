package post_method;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class postRequest01 extends HerOkuAppBaseUrl {
    /*
    When
	 		I send POST Request to the Url https://restful-booker.herokuapp.com/booking
	 		with the request body {
								    "firstname": "Selim",
								    "lastname": "Ak",
								    "totalprice": 11111,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2020-09-09",
								        "checkout": "2020-09-21"
								     }
								  }
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }
     */
    @Test
    public void post01() {
        //1)Set the url
        spec.pathParam("first", "booking");

        //2)Set the expected data
        HerOkuAppTestData expectedData = new HerOkuAppTestData();

        //3)Send POST Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData.expectedDataSetUp()).when().post("/{first}");
        response.prettyPrint();
        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println(actualData);

        //4)assert the output
        //1way by using GSON
        assertEquals(expectedData.expectedDataSetUp().get("firstname"),((Map)actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.expectedDataSetUp().get("lastname"),((Map)actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.expectedDataSetUp().get("totalprice"),((Map)actualData.get("booking")).get("totalprice"));
        assertEquals(expectedData.expectedDataSetUp().get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(expectedData.bookingDatesSetUp().get("checkin"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(expectedData.bookingDatesSetUp().get("checkout"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));
        //2.way//by using jsonpath
        JsonPath json=response.jsonPath();
        assertEquals(expectedData.expectedDataSetUp().get("firstname"),json.getString("booking.firstname"));
        assertEquals(expectedData.expectedDataSetUp().get("lastname"),json.getString("booking.lastname"));
        assertEquals(expectedData.expectedDataSetUp().get("totalprice"),json.getInt("booking.totalprice"));
        assertEquals(expectedData.expectedDataSetUp().get("depositpaid"),json.getBoolean("booking.depositpaid"));
        assertEquals(expectedData.expectedDataSetUp().get("checkout"),json.getString("booking.checkout"));
        assertEquals(expectedData.expectedDataSetUp().get("checkin"),json.getString("booking.checkin"));





    }
}
