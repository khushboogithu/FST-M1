package project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectTest {
	
	//SSH Key to hold with
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJjy2sQubYFbioBSM7vTKcgC6TTFX1OW5H3vXh1OOfJo";
	
	// Temp variable to share id
	int sshKeyId, keyId;
	
	//Declare the request & response specification
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
    @BeforeClass
    public void setup()
    {
    	    //POST: https://api.github.com/user/keys -> 201
    		//GET: https://api.github.com/user/keys/{keyId} -> 200
    		//DELETE: https://api.github.com/user/keys/{keyId} -> 204


    	//Initialize the request specification
    	requestSpec = new RequestSpecBuilder()
    			.setBaseUri("https://api.github.com/user/keys")    					
    			.addHeader("Content-Type", "application/json")
    			.addHeader("Authorization", "")
    			.addHeader("X-GitHub-Api-Version", "2022-11-28")
    			.build();
    	
    	//Initialize the response specification
    	responseSpec = new ResponseSpecBuilder()
    			.expectBody("title", Matchers.equalTo("TestKey"))
    			.expectResponseTime(Matchers.lessThanOrEqualTo(3000L))
    			.build(); 	
    	
      }
    
    @Test(priority = 1)
    public void postRequestTest()
    {
    	    
    	//Request body as Hashmap
    	HashMap<String, String> reqBody = new HashMap<>();
    	reqBody.put("title", "TestKey");
    	reqBody.put("key", "sshKey");
    	
    	//Send Request, save response
    	Response response = RestAssured.given()
    	.spec(requestSpec)
    	.body(reqBody)
    	.when().post();
    	
    	//Extract id from response
    	keyId =response.then().extract().path("Id");
    	
    	//Assertions
    	response.then().statusCode(200).spec(responseSpec);
    	
    	    	
      }
    
    @Test(priority = 2)
    public void getRequestTest() {
    	// Send request, receive response, and assert
    	RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).
    	when().get("/{keyId}").
    	then().statusCode(200).spec(responseSpec);
    }
    
    
    @Test(priority = 3)
    public void deleteRequestTest()
    {
    	    
    	//Send request, receive response and assert
    	RestAssured.given().spec(requestSpec).pathParam("keyId", keyId)
    	.when().delete("/{keyId}").
    	then().statusCode(204);       	    	
    }
    
	
}
