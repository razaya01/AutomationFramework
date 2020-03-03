
package Udemy;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthorizationCodeDemo {
	@Test
	public void testAuthGrantType() throws Throwable{
		String resourceServerUrl = "https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
		
		String getAuthoCodeInitials=resourceServerUrl.split("code=")[1];
		System.out.println(getAuthoCodeInitials);
		String AuthoCode = getAuthoCodeInitials.split("&scope")[0];
		System.out.println(AuthoCode);
		
		Response getTokenRes = given().urlEncodingEnabled(false)
				.queryParams("code",AuthoCode)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("grant_type", "authorization_code")
                .queryParams("state", "verifyfjdss")
                .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token");
		
		String accessTokenResponseBody = getTokenRes.asString();
		System.out.println(accessTokenResponseBody);
		JsonPath js = new JsonPath(accessTokenResponseBody);
		String accessToken = js.getString("access_token");
		
		Response getCourseRes = given().contentType("application/json")
				                .queryParam("access_token", accessToken)
				                .when().get("https://rahulshettyacademy.com/getCourse.php");
		
		String courseResponse = getCourseRes.asString();
		System.out.println(courseResponse);
		
		
		
                
		
		
	}
	
	
	
}
