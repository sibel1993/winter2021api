package get_method;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class GetRequest02 {

    /*
        When I send a GET request to REST API URL
        "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367"
        And content type is “application/JSON”
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
           for the course whose id is "608bb976c9e4a800151ab367"
        And "code" should be "WP100"
        And "image" should be "wordpress.jpg"
        And English "title" should be "Wordpress"
        And Turkish "shortDescription"  should be "Wordpress in nasıl kullanılacağını öğreneceğiz"
   */
    @Test
    public void get01(){

        //1)Set the url
        String url ="https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

        //2)set the expected date(we will learn it later )

       // 3)send a request
        Response response=given().accept("application/JSON").when().get(url);
        response.prettyPrint();
        //4)assertion


    }
}
