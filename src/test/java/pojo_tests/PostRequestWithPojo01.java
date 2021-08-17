package pojo_tests;

import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.TodosPojo;
import utils.JsonUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequestWithPojo01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
	 		with Post Request body  {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }
	 	Then
	 		Status code is 201
	 		And response body is like {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }

     */
    @Test
    public void post01(){
        //1)set the url
        spec.pathParam("first","todos");
        //2)set the expected data
        TodosPojo expectedPojo=new TodosPojo(21, "Tidy your room",false);
        System.out.println(expectedPojo.getUserId());
        System.out.println(expectedPojo.getTitle());
        System.out.println(expectedPojo.isCompleted());

        //3)send the request
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post("/{first}");
        response.prettyPrint();
        //4)assert the output
        //1way : use json to convert response body to TodosPojo
        TodosPojo actualPojo=response.as(TodosPojo.class);
        System.out.println("coming from GSON:" +actualPojo);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedPojo.getUserId(),actualPojo.getUserId());
        assertEquals(expectedPojo.getTitle(),actualPojo.getTitle());
        assertEquals(expectedPojo.isCompleted(),actualPojo.isCompleted());

        //1way : use object maooer convert response body to TodosPojo
        TodosPojo actualPojo2=JsonUtil.convertJsonToJava(response.asString(),TodosPojo.class);
        System.out.println("coming from ObjectMapper:" +actualPojo2);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedPojo.getUserId(),actualPojo2.getUserId());
        assertEquals(expectedPojo.getTitle(),actualPojo2.getTitle());
        assertEquals(expectedPojo.isCompleted(),actualPojo2.isCompleted());











    }
}
