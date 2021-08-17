package patch_method;

import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import static io.restassured.RestAssured.*;


public class PatchRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room"
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
     */
    @Test
    public void patch01(){
        //1)Set the URL
        spec.pathParams("first", "todos",
                "second", 180);
        //2)Set the expected data
        JsonPlaceHolderTestData expected = new JsonPlaceHolderTestData();
        //3)Send PATCH request
        Response response= given().spec(spec).contentType(ContentType.JSON).body(expected.expectedDataSetUp()).when().patch("/{first}/{second}");
        response.prettyPrint();

        //4)Assert the output
        response.then().assertThat().statusCode(200).body("title", equalTo(expected.expectedDataSetUp().get("title")),
                "userId", equalTo(expected.expectedDataSetUp().get("userId")),
                "completed", equalTo(expected.expectedDataSetUp().get("completed")));

    }

}
