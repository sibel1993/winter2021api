package get_method;

import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class GetRequest03 extends JsonPlaceHolderBaseUrl {
    /*
    When
		 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
		    And Accept type is “application/JSON”
		 Then
		    HTTP Status Code should be 200
		    And Response format should be “application/JSON”
		    And “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		    And “completed” is false
		    And “userId” is 2
     */
    @Test
    public void get01(){
        //1)set url
        //String url="https://jsonplaceholder.typicode.com/todos/23";//not recommended
        spec.pathParams("first","todos",
                "second",23);
        //2) set the expected data
        //3) send the request
        Response response=given().spec(spec).accept("application/json").when().get("/{first}/{second}");
        response.prettyPrint();
        System.out.println("status code"+response.getStatusCode());

        //4)assert the output
        /*
        when a test fail if java does not execute the the next steps it is called "hard assertion"(assertion)
        but there is assertion which is "Soft Assertion "(verification) ,it execute all tests and gives you report about
        the passed ones and failed ones
         */
//        responso.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType("application/JSON").body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
//                body("completed",equalTo(false)).
//                body("userId",equalTo(2));
        /*
        if you use body method for every step it uses hard assertion
        if you use just a single body method with multiple test step it gives you report for every failed test
         */
        //2.way
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                "completed",equalTo(false),
                "userId",equalTo(2));
        //3.way
        //http status code should be 200
        //assetEquals (expected,actual)
        assertEquals(200,response.getStatusCode());

        //response format should be "application/JSON"
        assertEquals("application/json; charset=utf-8",response.getContentType());


     //"title " is"et........"
        assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));


        //"completed is false
       assertTrue(response.asString().contains("\"completed"));

        //"userId is 2
        assertTrue(response.asString().contains("\"userId\": 2"));










    }
}
