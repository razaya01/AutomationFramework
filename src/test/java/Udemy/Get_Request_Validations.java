package Udemy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class Get_Request_Validations {
	@Test
	public void googlePlaceApiTestings() throws Throwable {
		RestAssured.baseURI = "https://maps.googleapis.com";

		//

		Response response = given().param("location", "-33.8670522,151.1957362").param("radius", "1500")
				.param("key", "AIzaSyDvNEs3MVG4_i0_CN9jDtJucw3ObJ63IAI").log().all().
				when()
				.get("/maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("results[0].name", equalTo("Sydney")).and()
				.body("results[1].place_id", equalTo("ChIJFfyzTTeuEmsRuMxvFyNRfbk")).and()
				.header("Server", "scaffolding on HTTPServer2").log().all().
				extract().response();
		String responseBody = response.asString();
		System.out.println(responseBody);
		JsonPath js = new JsonPath(responseBody);
		String hotelName = js.get("results[4].name");
		System.out.println("hotel name is :" + hotelName);

	}

}

/*
 * public static String GenerateStringFromResources(String path) throws
 * IOException { return new String(Files.readAllBytes(Paths.get(path)));
 * 
 * }
 */
