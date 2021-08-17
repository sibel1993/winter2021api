package delete_method;

import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 	Then
		 	Status code is 200
		 	And Response body is {“msg” = “Good”}
     */
    @Test
    public  void  delete01(){
        //1)set the url
        spec.pathParams("first","todos",
                "second",198);


        //2)set the expected data
        Map<String,Object> expected=new HashMap<>();

        //3)send the delete request
        Response response=given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //GSON DE-SERIALIZATION
        Map<String,Object> actual=response.as(HashMap.class);


        //4)assert the output
        //1.way : body()
        response.then().assertThat().statusCode(200);
        assertEquals(expected,actual);
        assertEquals(expected.size(),actual.size());



    }
}
