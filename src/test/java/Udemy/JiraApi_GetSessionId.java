package Udemy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class JiraApi_GetSessionId {
	@Test
	public void getCookiesSessionId()throws Throwable{
		RestAssured.baseURI = "https://localhost:8080";
		 given().header("Content-type","application/json").body("{ \"username\": \"myuser\", \"password\": \"mypassword\" }").
		 when().post("/rest/auth/1/session").
		 then().statusCode(200).extract().response();
	}
	
	
	
	
}
