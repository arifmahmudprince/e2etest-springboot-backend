package post;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.Constants;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class TestPostMethod {

    JSONObject requestJsonObject;

    @Test(description = "Create a student with all mandatory data present", priority = 0, testName = "CheckPostAPI 1")
    public void testStudentCreateWithMandatoryData(){

        requestJsonObject = new JSONObject();
        requestJsonObject.put("firstName", "Rudhvi");
        requestJsonObject.put("lastName", "Farzad");
        requestJsonObject.put("address", "Dhaka");
        requestJsonObject.put("department", "CSE");
        requestJsonObject.put("age", 29);
        System.out.println(requestJsonObject.toJSONString());

        given().
                contentType("application/json").
                body(requestJsonObject.toJSONString()).
                when().
                post(Constants.webUrl + Constants.postApiContextPath).
                then().
                statusCode(200);
    }

    @Test(description = "Create a student with mandatory data missing", priority = 0, testName = "CheckPostAPI 2")
    public void testStudentCreateWithoutMandatoryData(){

        requestJsonObject = new JSONObject();
        requestJsonObject.put("firstName", "Rudhvi");
        requestJsonObject.put("lastName", "Farzad");
        requestJsonObject.put("address", "Dhaka");
//        requestJsonObject.put("department", "CSE");
        requestJsonObject.put("age", 29);
        System.out.println(requestJsonObject.toJSONString());

        given().
                contentType("application/json").
                body(requestJsonObject.toJSONString()).
                when().
                post(Constants.webUrl + Constants.postApiContextPath).
                then().
                statusCode(400);
    }
}
