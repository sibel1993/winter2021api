package get_method;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest01 {
  /*
   ==Gherkin language ==
   "Given" : it declares prerequisites
   "When" : it defines action whic user will perform
   "then" : talk about outputs
   "and" : in any part of multiple things we can use And
  */
    /*
       When
           I send a GET Request to the URL https://api-techproed-test.herokuapp.com/courses
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK
   */

    @Test
    public void get01(){
        //follow these four steps in every API testing:
        //1. Set the url
        String url="https://api-techproed-test.herokuapp.com/courses";

        //2.Set the expected data (we will learn it later )


        //3.SEND the request

        Response response= given().
                               accept("application/json").
                           when().
                                get(url);
        //if you use "application/json" ,it means you want to see response body in json format
        //it is not must to use ,but some API might create a problem
        //to print response body use prettyPrint();
        response.prettyPrint();


        //4.Assert the things which are given in the test case
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
        //NOTE: if you execution stop after first error ,it is called "hard assertion"
        //if execution does not stop for any error it is called "sof assertion"
        //in soft assertion you can get separate reports for  each error
        //assertThat() is assertion
        //how to print content-type , status code , status line ..
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        System.out.println(response.getHeaders());




    }





















}
