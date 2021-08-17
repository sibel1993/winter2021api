package get_method;

import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class getDeneme extends JsonPlaceHolderBaseUrl {
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
        //set the url
        //String url="https://jsonplaceholder.typicode.com/todos/23";
        spec.pathParams("first","todos","second",23);
        //2Set the expected data

        //3)send the request
        Response response=given().spec(spec).accept("application/JSON").when().get("/{first}/{second}");
        response.prettyPrint();
        System.out.println("Status code : "+response.getStatusCode());

        //4)assert the out
//        response.then().
//                assertThat().
//                statusCode(200).
//                contentType("application/JSON").
//                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
//                body("completed",equalTo(false)).
//                body("userId",equalTo(2));

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/JSON").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),"" +
                        "completed",equalTo(false),"userId",equalTo(2));
           //3.way

        assertEquals(200,response.getStatusCode());
        assertEquals("Status code must be 200 but it is not ",200,response.getStatusCode());
        assertEquals("application/json; charset=utf-8",response.getContentType());
        assertTrue("Content type is not in json format",response.getContentType().contains("application/json"));

        assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));





    }

}
