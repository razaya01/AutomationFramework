package RestAssuredFramework;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class Tc001_Get_Request {

	@Test
	public void getWeatherDetails() throws Throwable {

		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city"; // base url
/*
		// httpRequest represent request object
		RequestSpecification httpRequest = RestAssured.given();

		// RESPONSE OBJECT
		Response response = httpRequest.request(Method.GET, "/Gangtok");

		String responseBody = response.getBody().asString();

		System.out.println("Response body is " + responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String getStatusLine = response.getStatusLine();
		System.out.println("status line is "+getStatusLine);
		Assert.assertEquals(getStatusLine, "HTTP/1.1 200 OK");
		*/
		 Response response = null;
		 
		  try {
		   response = RestAssured.given()
		    .when()
		    .get("/Gangtok"); 
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 
		  System.out.println("Response :" + response.asString());
		  System.out.println("Status Code :" + response.getStatusCode());
		  //System.out.println("Does Reponse contains 'employee_salary'? :" + response.asString().contains("employee_salary"));
		 
		 
		  assertEquals(200, response.getStatusCode());
		
		
		

	}

}
