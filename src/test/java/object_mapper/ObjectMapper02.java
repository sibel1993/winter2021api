package object_mapper;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.JsonUtil;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ObjectMapper02 extends HerOkuAppBaseUrl {
    /*
    When
		 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2

		 	Then
		 		Status code is 200
		 		And response body is like {
										    "firstname": "Mark",
										    "lastname": "Ericsson",
										    "totalprice": 726,
										    "depositpaid": true,
										    "bookingdates": {
										        "checkin": "2015-08-07",
										        "checkout": "2020-10-25"
										     }
										  }
     */
    @Test
    public void get01(){
        //set the url
        spec.pathParams("first","booking",
                "second",2);
        //set the expected data
        String expected="{\n" +
                "    \"firstname\": \"Mark\",\n" +
                "   \"lastname\": \"Ericsson\",\n" +
                "  \"totalprice\": 726,\n" +
                "  \"depositpaid\": true,\n" +
                "   \"bookingdates\": {\n" +
                " \"checkin\": \"2015-08-07\",\n" +
                "     \"checkout\": \"2020-10-25\"\n" +
                "   }";
        HashMap<String,Object>expectedMap= JsonUtil.convertJsonToJava(expected,HashMap.class);
        //3)send the request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap<String,Object>actualMap=JsonUtil.convertJsonToJava(response.asString(),HashMap.class);

        //4)assert the output
        Assert. assertEquals(actualMap.get("firstname"),expectedMap.get("firstname"));
        Assert. assertEquals(actualMap.get("lastname"),expectedMap.get("lastname"));
        Assert. assertEquals(actualMap.get("totalprice"),expectedMap.get("totalprice"));
        Assert. assertEquals(actualMap.get("depositpaid"),expectedMap.get("depositpaid"));
        Assert. assertEquals(actualMap.get("bookingdates.checkin"),expectedMap.get("bookingdates.checkin"));
        Assert. assertEquals(actualMap.get("bookingdates.checkout"),expectedMap.get("bookingdates.checkout"));












    }
}
