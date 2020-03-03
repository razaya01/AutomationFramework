package Udemy;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get_All_Location_In_Google_place {

	@Test
	public void printAllCities() throws Throwable {
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = given().param("location", "-33.8670522,151.1957362").param("radius", "1500")
				.param("key", "AIzaSyDvNEs3MVG4_i0_CN9jDtJucw3ObJ63IAI").when().get("/maps/api/place/nearbysearch/json")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("results[0].name", equalTo("Sydney")).and()
				.body("results[1].place_id", equalTo("ChIJFfyzTTeuEmsRuMxvFyNRfbk")).and()
				.header("Server", "scaffolding on HTTPServer2").extract().response();
		String responseBody = response.asString();
		System.out.println(responseBody);
		JsonPath js = new JsonPath(responseBody);
		int count = js.get("results.size()");
		for (int i=0; i<count; i++) {
			String hotelName = js.get("results["+i+"].name");
			System.out.println(hotelName);
		}
	}
}
