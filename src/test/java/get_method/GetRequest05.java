package get_method;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest05 extends HerOkuAppBaseUrl {
    /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  		Among the data there should be someone whose first name is “Mark” and last name is “Ericsson”
     */
    @Test
    public void get01(){
        //Set the url
        spec.pathParam("first","booking").queryParam("firstname","Eric","lastname","Brown");
        //2)set the expected data
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
       // response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));
    }
}

