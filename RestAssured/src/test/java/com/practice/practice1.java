package com.practice;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class practice1 {
	String baseuri = "https://automationexercise.com/api";
	String endpoint = "/productsList";

	@Test(enabled = false)
	public void firstgetrequest() {
		Response res = given().baseUri(baseuri).when().get(endpoint);
		res.prettyPrint();
		System.out.println("Status Line: " + res.statusLine());
		String response = res.asString();
		String jsonOnly = response.replaceAll("<[^>]*>", "");
		JsonPath js = new JsonPath(jsonOnly);
		List<Map<String, Object>> products = js.getList("products");
		for (Map<String, Object> product : products) {
			System.out.println(product.get("name") + " : " + product.get("brand"));
		}

	}

	String postendpoint = "/searchProduct";

	@Test(enabled = false)
	public void postrequest() {
		Response res = given().baseUri(baseuri)

				.contentType(ContentType.URLENC).formParam("search_product", "top").when().post(postendpoint);
		System.out.println(res.getStatusLine());
		res.prettyPrint();
	}

	String loginpoint = "/verifyLogin";

	@Test(enabled = false)
	public void postrequestlogin() {
		Response res = given().baseUri("https://automationexercise.com/api/").contentType(ContentType.URLENC).formParam("email", "invalid@test.com")
				.formParam("password", "wrongpassword").when().post("verifyLogin");

		String responseString = res.asString();
		String jsonOnly = responseString.replaceAll("<[^>]*>", "");
		JsonPath js = new JsonPath(jsonOnly);
		System.out.println("Response body: " + jsonOnly);

Assert.assertEquals(js.getString("responseCode"),200);
		// Response message
		Assert.assertEquals(js.getString("message"), "User not found!");

	}
	@Test(enabled=false)
	public void postrequestcreateuser() {
		Response res=given().baseUri(baseuri)
				// Request Parameters
                .formParam("name", "Rohit")
                .formParam("email", "rohit.pachauri2@gmail.com")
                .formParam("password", "Selenium@1234")
                .formParam("title", "Mr")
                .formParam("birth_date", "10")
                .formParam("birth_month", "05")
                .formParam("birth_year", "1995")
                .formParam("firstname", "Rohit")
                .formParam("lastname", "Pachauri")
                .formParam("company", "ABC Corp")
                .formParam("address1", "Street 1")
                .formParam("address2", "Near Park")
                .formParam("country", "India")
                .formParam("zipcode", "110001")
                .formParam("state", "Delhi")
                .formParam("city", "New Delhi")
                .formParam("mobile_number", "9876543210")
				.when().post("/createAccount");
		res.prettyPrint();
		System.out.println("Status Line: "+res.statusLine());
		
	}
	
	@Test(enabled=false)
	public void testdelete() {
		Response res=given()
				.baseUri(baseuri)
				.formParam("email", "rohit.pachauri2@gmail.com")
                .formParam("password", "Selenium@1234")
                .when()
                .delete("/deleteAccount");
		ValidatableResponse valres=res.then().statusCode(200);
		res.prettyPrint();
	}
	@Test
	public void testrequestemail() {
		Response res=given()
				.baseUri(baseuri)
				.formParam("email", "rohitpachauri2@gmail.com")
                .when()
                .get("/getUserDetailByEmail");
		ValidatableResponse valres=res.then().statusCode(200);
		res.prettyPrint();
		String strres=res.asString();
		String jsonOnly = strres.replaceAll("<[^>]*>", "");
		JsonPath js=new JsonPath(jsonOnly);
		System.out.println(js.getString("user.name"));
	}
	
	

}
