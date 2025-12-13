import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class JsonObjectusingJavaMap {
	String baseuri = "https://restful-booker.herokuapp.com";
	String basepath = "/auth";

	@Test()
	public void postrequestforauthtoken() {
		Map<String, String> authtoken = new HashMap<>();
		authtoken.put("username", "admin");
		authtoken.put("password", "password123");

		Response res = given().baseUri(baseuri).header("Content-Type", "application/json").body(authtoken).when()
				.post(basepath);
		res.prettyPrint();
		String token = res.jsonPath().getString("token");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(token);
	}

	String baseuri1 = "https://reqres.in/";
	String basepath1 = "api/users";
	String apikey = "reqres_7e7d83a13696487788cf25ab4fec4bc4";

	@Test()

	public void postrequestpart2() {
		Map<String, String> javamapbody = new HashMap<>();
		javamapbody.put("firstName", "Rohit");
		javamapbody.put("lastName", "Pachauri");
		javamapbody.put("age", "23");
		javamapbody.put("salary", "23000.56");
		Response res = given().baseUri(baseuri1).header("Content-Type", "application/json").header("x-api-key", apikey)
				.body(javamapbody).when().post(basepath1);
		res.prettyPrint();

	}

}
