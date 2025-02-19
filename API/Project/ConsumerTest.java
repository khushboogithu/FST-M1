package liveProject;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
//import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;



@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	
	//Set the headers
	Map<String, String> headers = new HashMap<>();
	
	//Create the Contract(Pact)
	//Dsl-domain Specific language
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		
		//Set the headers
		headers.put("Content-Type", "application/json");
		
		//The Request and the Response Body
		DslPart reqResBody = new PactDslJsonBody().
				numberType("id", 123).
				stringType("firstName", "Ksbu").
				stringType("lastName", "Saxena").
				stringType("email", "khushboosxn3@gmail.com");
		
		//Create the Pact
		return builder.given("POST Request").
				uponReceiving("A request to create a user").
				method("POST").path("/api/users").headers(headers).
				body(reqResBody).
				willRespondWith().status(201).body(reqResBody).toPact();	
		}
	
	//Consumer Test with Mock Provider	
  @Test
  @PactTestFor(providerName = "UserProvider", port = "8282")
  public void postRequestTest() {
	  
	  //Create a request body
	  Map<String, Object> reqBody = new HashMap<>();
	  reqBody.put("id", 123);
	  reqBody.put("firstName", "Ksbu");
	  reqBody.put("lastName", "Saxena");
	  reqBody.put("email", "khushboosxn3@gmail.com");
	  
	  //Send Request, get response and Add Assertions
	  given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all()
	  .when().post()
	  .then().statusCode(201).body("firstName", equalTo("Ksbu")).log().all();
  }
}
