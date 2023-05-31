package project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.hamcrest.CoreMatchers;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GitHub_RestAssured_Project {
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFH9hK+kiNWc050y6Eu2qX4nRUPY0YTMHP4NxqQQC16v";
    int sshKeyId;
    // Declare request specification
    RequestSpecification requestSpec;


    @BeforeClass
    public void setUp() {

        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set base URL
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization", " token 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")
                .addHeader("Content-Type", "application/json")
                // Build request specification
                .build();

    }
    @Test(priority=1)
    public void addNewUser() {
        // Create JSON request
        Map<String,String> reqBody=new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        // Send POST request
        Response response = given().spec(requestSpec) // Set headers
                .body(reqBody) // Add request body
                .when().post();
        

        // To assert success status code
        response.then().statusCode(201);

        // Get Id value
       sshKeyId =  response.then().extract().path("id");
    }

    @Test(priority=2)
    public void getUser() {
        Response response =
                given().spec(requestSpec) // Set headers
                        .when().pathParam("keyId", sshKeyId) // Set path parameter
                        .get("/{keyId}"); // Send GET request

        Reporter.log(response.print());

        // Assertion
        response.then().statusCode(200);
    }

    @Test(priority=3)
    public void deleteUser() {
        Response response =
                given().spec(requestSpec) // Set headers
                        .when().pathParam("keyId", sshKeyId) // Set path parameter
                        .delete("/{keyId}"); // Send DELETE request
        Reporter.log(response.print());

        // Assertion
        response.then().statusCode(204);
    }


}