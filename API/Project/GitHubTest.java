package liveProject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.Map;

//import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubTest {
	
	RequestSpecification ReqSpec;
	ResponseSpecification ResSpec;
	String sshKey = "";
	int sshKeyId=0;
	
  @BeforeClass
  public void setup() {
	  //Request Specification
	  ReqSpec = new RequestSpecBuilder().
			  setBaseUri("https://api.github.com/user/keys").
			  addHeader("Authorization","").
			  addHeader("Content-Type","application/json").
			  build();	  
			  
	  	  
	//Response Specification
	  ResSpec = new ResponseSpecBuilder().
			  //expectStatusCode(200).
			  expectResponseTime(lessThan(4000L)).
			  expectBody("key", equalTo(sshKey)).
			  expectBody("title", equalTo("TestAPIKey")).
			  build();
	  
  }
  
  //POST -> https://api.github.com/user/keys
  
  @Test(priority = 1)
  public void postRequest() {
	  
	  //Create Request Body
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", sshKey);
		
		Response response = given()
			.spec(ReqSpec) // Add Specification
			.body(reqBody) // Add request body
			.when().post(); // Send POST request
		
		//Extract the sshKey
		sshKeyId = response.then().extract().path("id");

		// Assertion
		response.then().statusCode(201).spec(ResSpec);	  
	
  }
  
  //Get -> https://api.github.com/user/keys/{keyId}
  
  @Test(priority = 2)
  public void getRequest() {
	  
	  given().spec(ReqSpec).pathParam("keyId", sshKeyId).
								when().get("/{keyId}").
								then().statusCode(200).spec(ResSpec);
			  }
  
  //Delete ->  https://api.github.com/user/keys/{keyId}
	 
	  @Test(priority = 3)
	  public void deleteRequest() {
		 
		  given().spec(ReqSpec).pathParam("keyId", sshKeyId).
			when().delete("/{keyId}").
			then().statusCode(204);
				
		  
	  } 
  
  
}

