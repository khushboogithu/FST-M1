package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class firstTest {
	
	@Test	
	public void getRequestWithQueryParam()
	{
		Response response = RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type","application/json") //Define Request Type
				.header("Accept","application/json") //Define Response Type
				.queryParam("status", "sold")
				.when()
				.get("/findByStatus");	
		
		//Print the response body
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString());
		
		//Print the response header
		System.out.println(response.getHeaders().asList());
		System.out.println(response.getHeader("E-Tag"));
		
		//then part is for assertion or extraction
		//Extract properties from the response body
		String petStatus = response.then().extract().path("[0].status");
		System.out.println("petStatus: " + petStatus);
		
		//Assertions
		Assert.assertEquals(petStatus, "sold");
		
		//RestAssured Assertions
		response.then().
		statusCode(200).
		body("[0].status", Matchers.equalTo("sold"));
	}
	
	public void getRequestWithPathParam()
	{
		RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type","application/json") //Define Request Type
				.header("Accept","application/json") //Define Response Type
				.pathParam("petId", 12)
				.when()
				.get("/{petId}")
				.then()	
				.statusCode(200)
				.body("status", Matchers.equalTo("available"))
				.body("name", Matchers.equalTo("doggie"));
	}

}
