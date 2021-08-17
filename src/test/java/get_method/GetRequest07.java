package get_method;


import Base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest07 extends JsonPlaceHolderBaseUrl {
   /* When
    I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
    Then
    Status code is 200
            1)Print all ids greater than 190 on the console
    Assert that there are 10 ids greater than 190
            2)Print all use id less than 5 on the console
    Assert that maximum user id less than 5 is 4
            3)Print all titles  whose ids are less than 11
    Assert that “delectus aut autem” is one of the titles whose id is less than 11

    */
    @Test
    public void get01(){
        //set the url
        spec.pathParam("first","todos");
        //2)set the expected data

        //3)send trhe request
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        JsonPath json=response.jsonPath();

       // 1)Print all ids greater than 190 on the console
        //"findAll{it.id>190}"==>tells to groovy to look at the json data under the condition  id>190
        //".id" tells to groovy to select what
        List<Integer> idList=json.getList("findAll{it.id>190}.title");
        System.out.println(idList);
        // Assert that there are 10 ids greater than 190
        assertEquals(10,idList.size());

        // 2)Print all use id less than 5 on the console
        List<Integer> userIdList =json.getList("findAll{it.userId<5}.userId");
        System.out.println(userIdList);

        // Assert that maximum user id less than 5 is 4
        Collections.sort(userIdList);
        assertEquals((Integer)4,userIdList.get(userIdList.size()-1));

       // 3)Print all titles  whose ids are less than 11
        List<String>titleList=json.getList("findAll{it.id<5}.title");
        System.out.println(titleList);

        // Assert that “delectus aut autem” is one of the titles whose id is less than 11
        boolean result=titleList.stream().anyMatch(t->t.equals("delectus aut autem"));
        assertTrue(result);












    }



}
