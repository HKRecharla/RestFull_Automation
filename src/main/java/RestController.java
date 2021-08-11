import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RestController {


    protected static RequestSpecification rs = null;


    protected static Response response =null;

    public static void getRequest(){
        Map<String,String > map = new HashMap<>();
        map.put("my-sample-header","Lorem ipsum dolor sit amet");

        response = RestAssured.given().relaxedHTTPSValidation()
                .when().headers(map).get("https://postman-echo.com/headers");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public void test(){
        getRequest();
    }


}
