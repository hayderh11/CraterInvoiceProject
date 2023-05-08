package API_Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APILoginPage
{
	Response response;
	String token;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://crater.primetech-apps.com";

	}
	
   
	@Test
	public void testcase1ValidLogin() {
		
		// Set valid endpoint
		String validEndpoint = "/api/v1/auth/login";
		
		// Set request body
		String requestBody = "{"
				+ "\"username\":\"accounts@crater.com\","
				+ "\"password\":\"primetech@school\","
				+ "\"device_name\":\"mobile_app\"}";
		
		// Send POST request
		response = RestAssured.given()
				.contentType("application/json")
				.accept("application/json")
				.body(requestBody)
				.post(validEndpoint).thenReturn();
		
		// Verify response status code
		Assert.assertEquals(response.getStatusCode(), 200);
				
		// Verify response token
		response.prettyPrint();
		token = response.jsonPath().getString("token");
	}
	
	
	@Test
	public void testcase2IncorrectEndpoint() {
		// Set invalid endpoint
		String invalidEndpoint = "/api/v1/auth/loginn";
				
		// Set request body
		String requestBody = "{"
				+ "\"username\":\"accounts@crater.com\","
				+ "\"password\":\"primetech@school\","
				+ "\"device_name\":\"mobile_app\"}";
				
		// Send POST request
		response = RestAssured.given()
				.contentType("application/json")
				.accept("application/json")
				.body(requestBody)
				.post(invalidEndpoint).thenReturn();
				
		// Verify response status code
		Assert.assertEquals(response.getStatusCode(), 404);
	}
		
	
	@Test
	public void testcase3ImproperBody() {
		// Set valid endpoint
		String validEndpoint = "/api/v1/auth/login";
				
		// Set request body
		String requestBody = "{"
				+ "\"username\":\"accounts@crater.com\","
				+ "\"password\":\"primetech@school\",";
				
		// Send POST request
		response = RestAssured.given()
				.contentType("application/json")
				.accept("application/json")
				.body(requestBody)
				.post(validEndpoint).thenReturn();
				
		// Verify response status code
		Assert.assertEquals(response.getStatusCode(), 422);	
	}
	
	
	@Test 
	public void testcase4WrongUsernamePassword() {
		
		// Set valid endpoint
		String validEndpoint = "/api/v1/auth/login";
				
		// Set request body with invalid username and password
		String requestBody = "{"
				+ "\"username\":\"accounts@yahoo.com\","
				+ "\"password\":\"primetech@yahoo\","
				+ "\"device_name\":\"mobile_app\"}";
				
		// Send POST request
		response = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.body(requestBody)
		.post(validEndpoint).thenReturn();
				
		// Verify response status code
		Assert.assertEquals(response.getStatusCode(), 405);
		}
		
		
	
	
	

	
}