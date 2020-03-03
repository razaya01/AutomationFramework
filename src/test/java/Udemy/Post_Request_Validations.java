package Udemy;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Post_Request_Validations {
	@Test(priority = 1)
	public void addPlaceInGoogleMap() throws Throwable {
		RestAssured.baseURI = "http://216.10.255.166"; //qaclick123
		//Response response = null;
		//response = RestAssured.
		Response res = given().
				queryParam("key","qaclick123").
				body("{"+ 
				"\"location\": {"+
				"\"lat\": -33.8669710,"+
				"\"lng\": 151.1958758"+ 
				"},"+ 
				"\"accuracy\": 50,"+ 
				"\"name\": \"Google Shoes!\","+ 
				 "\"phone_number\": \"(02) 9374 4000\","+
				"\"address\": \"48 Pirrama Road, Pyrmont, NSH 2009, Australial\","+
				"\"types\": [\"shoe_store\"],"+
				 "\"website\": \"http://www.google.com.au\","+ 
				"\"language\": \"en-AU\""+
				 "}").
				when().
				post("/maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		
		System.out.println(res);
				 
		
	
	}
	@Test(priority = 0)
	public void createUser() throws Throwable {
		RestAssured.baseURI = "https://reqres.in/";
		String requestBody = "{"+
			   " \"name\": \"morpheus\","+
			    "\"job\": \"leader\""+
			"}";
		Response res = given().
				body(requestBody).
				when().
				post("/api/users").
				then().assertThat().statusCode(201).extract().response();
		String responseBody = res.asString();
		System.out.println(responseBody);
		JsonPath js = new JsonPath(responseBody);
		String id = js.get("id");
		System.out.println("id of the response is :"+id);
		
	}

}

