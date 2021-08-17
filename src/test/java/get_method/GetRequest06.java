package get_method;

import Base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import org.testng.asserts.SoftAssert;

public class GetRequest06 extends HerOkuAppBaseUrl {
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
        spec.pathParams("first","booking",
                "second",5);
        //2)set the accept data

        //3)send request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
       // 3)assert the output
//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("firstname", equalTo("Mark"),
//                        "lastname",equalTo("Jones"),
//                        "totalprice",equalTo(576),
//                        "depositpaid",equalTo(false),
//                        "bookingdates.checkin", equalTo("2020-12-21"));
        //JsonPath is used to navigate inside json data
        JsonPath json=response.jsonPath();
                       //2.way:
        assertEquals("Status code is not matching",200,response.getStatusCode());
        assertEquals("content type is not Json","application/json; charset=utf-8",response.getContentType());
       // assertEquals("firstname is not matching ", "Sally",json.getString("firstname"));
       // assertTrue("last name is not matching", json.getString("lastname").equals("Jackson"));
      //  assertTrue("total price is not matching", json.getInt("totalprice")==530);
      //  assertTrue("deposit is not matching ",json.getBoolean("depositpaid")==false);
      //  assertEquals("Checkin data is not matching ","2016-08-15" ,json.getString("bookingdates.checkin"));
      //  assertTrue("Checkout data is not matching ",json.getString("bookingdates.checkout").equals("2021-01-26"));

        //3.way:
        /*
        softassertion(verification):execution is not stopped in failer
        to use soft assertion we have 3 steps
        1) create an object from softAssert class
        2)buy using the object , use assertEquals method , assertTrue(),assertFalse()
        3)DO NOT FORGET to type to use assertAll() method at the end
                 */
        //1
       SoftAssert softAssert =new SoftAssert();
       //2
      //  softAssert.assertEquals(json.getString("firstname"),"Sally","First name is not matching");
       // softAssert.assertEquals(json.getString("lastname "),"Jones","lastname is not matching");
       // softAssert.assertEquals(json.getInt("totalprice"),666,"totalprice is not matching");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2021-01-22","checkout is data  is not matching");
       //3
        softAssert.assertAll();










    }

}
