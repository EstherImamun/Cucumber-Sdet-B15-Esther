package API;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExampleTest {

       // String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTk1Mjc5ODYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5OTU3MTE4NiwidXNlcklkIjoiNjA2NCJ9.oRAIyNqcClp7qO0Qd3ghRGxwBWBnCdqlDnvPUZfmZN0";
        static String employee_id;

        @Test
        public void bgetCreatedEmployee(){
                RequestSpecification preparedRequest= given().
                        header("Content-Type", "application/json").
                        header("Authorization", token).queryParam("employee_id",employee_id);

                // hitting the endpoint
                Response response = preparedRequest.when().get("/getOneEmployee.php");
                response.prettyPrint();

                // verify the response
                response.then().assertThat().statusCode(200);

                String tempEmpId = response.jsonPath().getString("employee.employee_id");

                // we have 2 emp id, one is global and the second is local

                Assert.assertEquals(employee_id, tempEmpId);

        }

        @Test
        public void acreateEmployee(){


                RequestSpecification preparedRequest = given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", token)
                        .body("""
                    {
                        "emp_firstname": "Chad",
                        "emp_lastname": "Charles",
                        "emp_middle_name": "mr",
                        "emp_gender": "M",
                        "emp_birthday": "2010-02-05",
                        "emp_status": "Confirmed",
                        "emp_job_title": "Engineer"
                    }
                    """);


              /*  // prepare the request
                RequestSpecification  preparedRequest=given().
                        header("Content-Type", "application/json").
                        header("Authorization", token).body("{\n" +
                                "    \"emp_firstname\": \"Chad\",\n" +
                                "    \"emp_lastname\": \"Charles\",\n" +
                                "    \"emp_middle_name\": \"mr\",\n" +
                                "    \"emp_gender\": \"M\",\n" +
                                "    \"emp_birthday\": \"2010-02-05\",\n" +
                                "    \"emp_status\": \"Confirmed\",\n" +
                                "    \"emp_job_title\": \"Engineer\"\n" +
                                "}");*/

                // hitting the endpoint/ send the request
                Response response = preparedRequest.when().post("/createEmployee.php");

                // verifying the assertions/ get response
                response.then().assertThat().statusCode(201);
                // it will print the output in the console // only for API
                response.prettyPrint();

                // we are capturing employee id from the response
                employee_id = response.jsonPath().getString("Employee.employee_id");
                System.out.println(employee_id);


                // verifying the first name in the response body
                response.then().assertThat().
                        body("Employee.emp_firstname", equalTo("Chad"));

                // verifying the last name in the response body
                response.then().assertThat().
                        body("Employee.emp_lastname", equalTo("Charles"));


                // verify the response headers
                response.then().assertThat().header("Content-Type", "application/json");


                System.out.println("My test case is passed");

        }
        // in homework, create a method to get all employee status and job title..
       @Test
        public void cupdateEmployee(){
                RequestSpecification preparedRequest = given().
                        header("Content-Type", "application/json").
                        header("Authorization", token).
                        body("{\n" +
                                "    \"employee_id\": \""+employee_id+"\",\n" +
                                "    \"emp_firstname\": \"Jennifer\",\n" +
                                "    \"emp_lastname\": \"Stevens\",\n" +
                                "    \"emp_middle_name\": \"ms\",\n" +
                                "    \"emp_gender\": \"F\",\n" +
                                "    \"emp_birthday\": \"2005-08-11\",\n" +
                                "    \"emp_status\": \"Probation\",\n" +
                                "    \"emp_job_title\": \"Doctor\"\n" +
                                "}");

                // hitting the endpoint
                Response response = preparedRequest.when().put("/updateEmployee.php");
                response.then().assertThat().statusCode(200);
               response.prettyPrint();


                // for verification
                response.then().assertThat().body("Message", equalTo("Employee record Updated"));
        }
        @Test
        public void dgetUpdatedEmployee(){
                RequestSpecification preparedRequest= given().
                        header("Content-Type", "application/json").
                        header("Authorization", token).queryParam("employee_id",employee_id);

                Response response = preparedRequest.when().get("/getOneEmployee.php");
                response.prettyPrint();

                response.then().assertThat().statusCode(200);


                // if you want to verify the body of the response, you can do that using hamcrest matchers
        }



}
