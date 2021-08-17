package get_method;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest001 {
    /*
    IN API test cases and automation scripts we use "Given ","When","Then", and "And"
    "Given" :it declares prerequisites
    "When" : it declares the action which user will perform
    "then" : it declares outputs
    "And" : it can be used after "given ","when" ,"and" "then" for multiple actions

     */
    /*
    When
		     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		     Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void get01(){
        //1)set the URL
        String url="https://restful-booker.herokuapp.com/booking/3";
        //2)Set the expected data (learn it later )
        //3)type automation script to sent GET request
        Response response = given().when().get(url);
        response.prettyPrint();


        //4)Assert the output
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

        //How to print content-type, statuss code, status line, etc. on the console...
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Status type: "+response.getContentType());
        System.out.println("Status line: "+response.getStatusLine());
        System.out.println("All headers: "+response.getHeaders());
        System.out.println("Server: "+response.getHeader("Server"));
        System.out.println("Time: "+response.getTime());




    }


}
