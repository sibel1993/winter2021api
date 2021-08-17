package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class JsonUtil {

    //create  a method to convert Json data to Java Object(De-Serialization)

    //1.step: create  an Object Mapper(CLASS) Class Object
    private static ObjectMapper mapper ;

    static{
        mapper=new ObjectMapper();

    }
    //2.Step: create de-serialization method
    public static <T> T convertJsonToJava(String json, Class<T> cls){
    T javaResult=null;
    try {
        javaResult = mapper.readValue(json, cls);
    }catch(IOException e){
        System.out.println("Json could not be convert to java object:"+e.getMessage());
    }
    return javaResult;
    }
    //create a method to convert java object to json data (serialization)
    public  static String convertJavaToJson(Object obj){
       String jsonResult=null;

        try {
            jsonResult= mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("java object could not be convert to json data "+ e.getMessage());
        }
        return jsonResult;

    }


}
