package get;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.Constants;

import static io.restassured.RestAssured.*;

public class TestGetMethod {

    @Test (description = "Check whether the https status code is okay or not", priority = 0)
    public void testStatusCode(){
        given().
                get(Constants.webUrl + Constants.getApiContextPath).
                then().
                statusCode(200);
    }

    @Test (description = "Check whether the data of first two students are okay or not",
            priority = 1, dependsOnMethods = "testStatusCode")
    public void testStudentsData(){
        given().
                get(Constants.webUrl + Constants.getApiContextPath).
                then().
                body("firstName[0]", Matchers.equalTo("Prince")).
                body("lastName[1]", Matchers.equalTo("Johora Jui")).
                body("age[0]", Matchers.greaterThanOrEqualTo(30)).
                body("age[1]", Matchers.lessThanOrEqualTo(30)).
                log().all();
    }

}
