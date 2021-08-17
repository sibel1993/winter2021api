package get_method;

import Base_urls.DummyBaseUrl;
import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class GetRequest04 extends JsonPlaceHolderBaseUrl {
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
    public void get01(){
        //1)set url
        spec.pathParam("first","todos");
        //2)set expected data
        //3)sent the request
       Response response=given().spec(spec).accept("application/json").when().get("/{first}");

        response.prettyPrint();
        //4)assert the output
        response.
                then().
                assertThat().
                statusCode(200).contentType(ContentType.JSON).//instead of "application/json"you can use "ContentType.JSON"
                body("id", hasSize(200)).
                body("title",hasItem("quis eius est sint explicabo")).
                body("userId",hasItems(2,7,9));
    }

}
