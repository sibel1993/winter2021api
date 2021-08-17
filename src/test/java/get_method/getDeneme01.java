package get_method;

import Base_urls.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class getDeneme01 extends DummyBaseUrl {

     /*
    When
I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos
  And Accept type is "application/json"
  Then
  HTTP Status Code should be 200
  And Response format should be "application/json"
  And there should be 200 todos
  And "quis eius est sint explicabo" should be one of the todos
  And 2, 7, and 9 should be among the userIds
     */
    @Test
    public void geto1(){
        //1) set the url
       spec.pathParams("first","api",
               "second","v1",
               "third","employees");
       //2) set expected data

        //3)sent a request
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();








    }

}
