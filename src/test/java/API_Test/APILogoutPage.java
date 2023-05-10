package API_Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.annotations.BeforeClass;

public class APILogoutPage {
	
	String endpoint = "/logout";
	RequestSpecification request = RestAssured.given();
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://crater.primetech-apps.com";

	}	
	@Test
	public void testLogoutValid() {
		 Response response = given()
		            .header("Authorization", "Bearer {access_token}")
		            .when()
		            .post("http://crater.primetech-apps.com/logout")
		            .then()
		            .extract().response();

		    assertEquals(200, response.statusCode());
		    assertEquals("Logged out successfully", response.jsonPath().get("message"));
		}
		
   @Test
    public void testLogoutwithIncorrectAuthToken() {
	   given()
       .header("Authorization", "Bearer {incorrect_access_token}")
   .when()
       .post("http://crater.primetech-apps.com/logout")
   .then()
       .statusCode(401);
       
}

@Test
public void testLogoutWithIncorrectEndpoint() {
	Response response = request.post("/incorrectEndpoint" + endpoint);
	assertEquals(404, response.getStatusCode());
	response = request.post(endpoint);
	assertEquals(200, response.getStatusCode());
	
	
}


	
		
		
		
	}
	

