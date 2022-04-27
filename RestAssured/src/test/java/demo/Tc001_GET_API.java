package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc001_GET_API {

	@Test
	void getbookdetails() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/Books");

		String respbody = response.getBody().asString();

		int statusCode = response.getStatusCode();

		System.out.println(statusCode);

		Assert.assertEquals(statusCode, 200);

		System.out.println(respbody);
	}
}
