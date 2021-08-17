package get_method;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import  static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class getDeneme02  extends HerOkuAppBaseUrl {
     /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
	  Then
		  HTTP Status Code should be 200
		  And response content type is “application/JSON”
		  And response body should be like;
		  { “firstname”: “Sally”,
		    “lastname”: “Ericsson”,
		    “totalprice”: 111,
		    “depositpaid”: false,
		    “bookingdates”: { “checkin”: “2017-05-23",
		                      “checkout”:“2019-07-02" }
		  }
     */
    @Test
    public void get01(){
        //set the url
        spec.pathParams("first","booking",
                "second",5);
        //SET THE EXPECTED DATA

        //SET THE REQUEST
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //4)assert the output
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Ericsson"),
                        "bookingdates.checkin",equalTo("2017-03-19"),
                        "bookingdates.checkout",equalTo("2020-12-31"));
    }





}
