package API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeworkTest {

   // String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";//
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTk1Mjc5ODYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5OTU3MTE4NiwidXNlcklkIjoiNjA2NCJ9.oRAIyNqcClp7qO0Qd3ghRGxwBWBnCdqlDnvPUZfmZN0";


    @Test
    public void agetEmployeeStatus(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").header("Authorization", token);

        // hitting the endpoint/send the request
        Response response = preparedRequest.when().get("/employeementStatus.php");
        response.prettyPrint();

        // verifying the status code
        response.then().assertThat().statusCode(200);
    }


    @Test
    public void bgetJobTitle(){ // this is my homework
        RequestSpecification preparedRequest = given().
                header("Content-Type", "applicaiton/json").
                header("Authorization", token);

        // hitting the endpoint/send the request
       Response response = preparedRequest.when().get("/jobTitle.php");
       response.prettyPrint();

       // verify the status code
        response.then().assertThat().statusCode(200);

    }

}









