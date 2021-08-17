package get_method;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class getRequest002 extends HerOkuAppBaseUrl {
    /*
    When
			    I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/1001
			Then
				HTTP Status code should be 404
			And
				Status Line should be HTTP/1.1 404 Not Found
			And
	     Response body contains “Not Found”
	         And
	     Response body does not contain “TechProEd”
	     And
	     Server is "Cowboy"
     */
    @Test
    public void get02(){
        //1. set the url
       // String url="https://restful-booker.herokuapp.com/booking/1001";
        spec .pathParams("first","booking",
                "second",1001);


        //2. set the expected data
        //3.send the request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4.assert the output
        response.then().assertThat().statusCode(404);

        //assertTrue(true)==>pass    assertTrue(false)==>fail
        assertTrue(response.asString().contains("Not Found"));

        //assertFalse(false)==>pass      assertFalse(true)==>fail

        assertFalse(response.asString().contains("TechProed"));

        //assertEquals (firstparameter,secondparameter); if the first parameter matches with the second parameter
       // you will get passed otherwise you will get failed
        assertEquals(response.getHeader("Server"),"Cowboy");

        //how to see status code on the console
        System.out.println("Status code: "+ response.getStatusCode());
        //how to see status line on the console
        System.out.println("Status line: "+ response.getStatusLine());



    }
}
