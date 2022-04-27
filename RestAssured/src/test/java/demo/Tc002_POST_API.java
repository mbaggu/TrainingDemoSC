package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc002_POST_API {

		@SuppressWarnings("unchecked")
		@Test
		void postbookdetails() {

			RestAssured.baseURI = "https://demoqa.com/Account/v1";
			RequestSpecification httpRequest = RestAssured.given();
			JSONObject requestParams= new JSONObject();
			
			requestParams.put("userId", "myname"); 
			requestParams.put("isbn", "9781449325862");
			
			
			httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request 
			httpRequest.body(requestParams.toJSONString()); // Post the request and check the response
			
			
			Response response = httpRequest.post("/BookStoreV1BooksPost");
			
			
		String body =	response.getBody().asString();
			
			System.out.println(body);
			
		
		}

}
