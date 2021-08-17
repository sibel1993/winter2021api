package get_method;

import Base_urls.JsonPlaceHolderBaseUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class getRequest08 extends JsonPlaceHolderBaseUrl {

    /*
    De-Serialization: converting json data to any java object is called "De-Serialization"
    Serialization: converting java object to json data is called "serialization"
    to do de-serialization and serialization ,we have 2 ways
    1)using GSON
    2)Using object Mapper
     */
    /*
    When
	  		I send GET Request to https://jsonplaceholder.typicode.com/todos/2
	  Then
	  		Status code is 200
	  		And “completed” is false
	  		And “userId” is 1
	  		And “title” is “quis ut nam facilis et officia qui”
	  		And header “Via” is “1.1 Vegur”
	  		And header “Server” is “cloudflare”
     */
    @Test
    public void get01(){
        //1)set the url
        spec.pathParams("first","todos",
                "second",2);

        //2)set the expected data
        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("Status code ", 200);
        expectedDataMap.put("completed",false);
        expectedDataMap.put("userId",1);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        //3)send the request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //GSON:DE-SERIALIZATION==>Json---->java object
        Map<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println("Java object from Json:"+actualDataMap);

        //GSON:SERIALIZATION==>Java object---->json data
        Gson gson=new Gson();
       String jsonFromJavaObject= gson.toJson(actualDataMap);
        System.out.println("Json from java object:"+ jsonFromJavaObject);

        assertEquals(expectedDataMap.get("statusCode "), response.getStatusCode());
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("Via"), response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));



    }





}
