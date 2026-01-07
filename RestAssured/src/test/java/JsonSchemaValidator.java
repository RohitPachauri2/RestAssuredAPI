import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.*;

public class JsonSchemaValidator {
	String baseuri = "https://restful-booker.herokuapp.com/";
	String endpoint = "auth";

	@Test
	public void TestMethod() {
		Map<String, String> map = new HashMap<>();
		map.put("username", "admin");
		map.put("password", "password123");
		RequestSpecification reqspec = given().baseUri(baseuri).body(map).header("Content-Type", "application/json");
		Response res = reqspec.post(endpoint);
		ValidatableResponse val=reqspec.post(endpoint)
				.then()
				.statusCode(200)
				.body("token", Matchers.notNullValue())
				.body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(new File("D:\\rohit\\Education\\schema.json")));

		
		res.prettyPrint();
		System.out.println(val);

	}

}
