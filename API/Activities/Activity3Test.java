package activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

//import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3Test {
	
	RequestSpecification ReqSpec;
	ResponseSpecification ResSpec;
	//int petId = 0;
	
  @BeforeClass
  public void setup() {
	  //Request Specification
	  ReqSpec = new RequestSpecBuilder().
			  setBaseUri("https://petstore.swagger.io/v2/pet").
			  addHeader("Content-Type","application/json").
			  build();	  
			  
	  	  
	//Response Specification
	  ResSpec = new ResponseSpecBuilder().
			  expectStatusCode(200).
			 // expectBody("status", equalTo("alive")).
			  expectResponseTime(lessThanOrEqualTo(3000L)).			  
			  build();
	  
  }
  
  @DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 77232, "Riley", "alive" }, 
			{ 77233, "Hansel", "alive" } 
		};
		return testData;
	}
  
  //POST -> https://petstore.swagger.io/v2/pet
  
  @Test(priority = 1, dataProvider = "petInfo")
  public void postRequest(int petId, String petName, String petStatus) {
	  
	  //Create Request Body
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);

		Response response = given()
			.spec(ReqSpec) // Add Specification
			.body(reqBody) // Add request body
			.when().post(); // Send POST request
		
		//Extract the petID
		//petId = response.then().extract().path("id");

		// Assertion
		response.then().spec(ResSpec).body("id", equalTo(petId));
		response.then().spec(ResSpec).body("name", equalTo(petName));
		response.then().spec(ResSpec).body("status", equalTo(petStatus));	  
	
  }
  
  //Get -> https://petstore.swagger.io/v2/pet/{petId}
  
  @Test(priority = 2, dataProvider = "petInfo")
  public void getRequest(int petId, String petName, String petStatus) {
	  
	  given().spec(ReqSpec).pathParam("petId", petId).
								when().get("/{petId}").
								then().spec(ResSpec).body("status", equalTo(petStatus));

			  }
  
  //Delete -> https://petstore.swagger.io/v2/pet/{petId}
	 
	  @Test(priority = 3,dataProvider = "petInfo")
	  public void deleteRequest(int petId, String petName, String petStatus) {
		 
		  given().spec(ReqSpec).pathParam("petId", petId).
			when().delete("/{petId}").
			then().spec(ResSpec).body("message", equalTo(""+petId));
				
		  
	  } 
  
  
}

