package get_method;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class GetRequest09 extends HerOkuAppBaseUrl {
    /*
    When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then
	 		Response body should be like that;
	 		{
			    “firstname”: “Eric”,
			    “lastname”: “Smith”,
			    “totalprice”: 555,
			    “depositpaid”: false,
			    “bookingdates”: {
			        “checkin”: “2016-09-09”,
			        “checkout”: “2017-09-21”
			     }
			}
     */
    @Test
    public void get01(){
        //1)SET THE URL
        spec.pathParams("first","booking",
                "second",1);
        //2)SET THE EXPECTED DATA
        Map<String,String>bookingdates=new HashMap<>();
        bookingdates.put("checkin","2016-01-07");
        bookingdates.put("checkout", "2020-07-06");

        Map<String,Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("firstname","Mark");
        expectedDataMap.put("lastname","Smith");
        expectedDataMap.put("totalprice",190);
        expectedDataMap.put("depositpaid",true);
        expectedDataMap.put("bookingdates",bookingdates);
        System.out.println(expectedDataMap);
        //send the request
        Response response =given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
//use json for de-serialization
        Map<String,Object>actualMap=response.as(HashMap.class);
        System.out.println(actualMap);
        //assert the output
        assertEquals(expectedDataMap.get("firstname"),actualMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualMap.get("totalprice"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"),((Map)actualMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"),((Map)actualMap.get("bookingdates")).get("checkout"));






    }


}
