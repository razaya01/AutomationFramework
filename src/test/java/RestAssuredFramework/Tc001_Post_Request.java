package RestAssuredFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc001_Post_Request {

	@Test
	public void registrationSuccessfull() throws Throwable {
/*
		RestAssured.baseURI = "http://restapi.demoqa.com/customer"; // base url

		// httpRequest represent request object
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("FisrtName", "JohnXYZ");
		requestParams.put("LastName", "XYZJohn");
		requestParams.put("UserName", "JohnXYZ");
		requestParams.put("Password", "JohnXYZxyx");
		requestParams.put("Email", "JohnXYZ@gmail.com");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		// RESPONSE OBJECT
		Response response = httpRequest.request(Method.POST, "/register");
		
		String responseBody = response.getBody().asString();

		System.out.println("Response body is " + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);
		Assert.assertEquals(statusCode, 201);

		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
*/
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		 
        String requestBody = "{\n" +
            "  \"name\": \"tammy\",\n" +
            "  \"salary\": \"5000\",\n" +
            "  \"age\": \"20\"\n" +
            "}";
 
 
        Response response = null;
 
        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/create");
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Reponse contains 'tammy'? :" + response.asString().contains("tammy"));
 
 
        assertEquals(200, response.getStatusCode());
    }
	

public static String GenerateStringFromResources(String path) throws IOException {
	return new String(Files.readAllBytes(Paths.get(path)));
	
}
}
