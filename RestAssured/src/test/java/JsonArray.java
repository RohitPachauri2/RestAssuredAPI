import static io.restassured.RestAssured.*;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonArray {

	@Test
	public void jsonarraywayjsonobject() {

		// objects----------------------------------

		JSONObject user1 = new JSONObject();

		user1.put("firstname", "rohit");
		user1.put("lastname", "pachauri");
		user1.put("age", "23");
		user1.put("salary", "76000");

		JSONObject user2 = new JSONObject();

		user2.put("firstName", "mohit");
		user2.put("lastName", "sharma");
		user2.put("age", "26");
		user2.put("salary", "79800");

		// array with multiple object---------

		JSONArray userarray = new JSONArray();
		userarray.add(user1);
		userarray.add(user2);

		// post request to create with multiple objects:----------------

		String baseuri1 = "https://reqres.in/";
		String basepath1 = "api/users";
		String apikey = "reqres_7e7d83a13696487788cf25ab4fec4bc4";

		RequestSpecification reqspec = given().basePath(basepath1).baseUri(baseuri1).header("x-api-key", apikey)
				.header("Content-Type", "application/json").body(userarray);

		Response res = reqspec.post();
		res.prettyPrint();

		Assert.assertEquals(res.getStatusCode(), 201);
	}

	
	// using objects as map and list as
	// jsonarray-------------------------------------
	
	
	@Test
	public void jsonarrayway2list() {

		// objects as map----------------------------------

		Map<String, String> map1 = new HashMap<>();

		map1.put("firstname", "rohit2");
		map1.put("lastname", "pachauri2");
		map1.put("age", "23");
		map1.put("salary", "76900");

		Map<String, String> map2 = new HashMap<>();

		map2.put("firstName", "mohit2");
		map2.put("lastName", "sharma2");
		map2.put("age", "26");
		map2.put("salary", "798080");

		// array with multiple objects as as map using list---------

		List<Map<String, String>> userarray = new ArrayList<>();
		userarray.add(map1);
		userarray.add(map2);

		// post request to create with multiple objects:----------------

		String baseuri1 = "https://reqres.in/";
		String endpoint = "api/users";
		String apikey = "reqres_7e7d83a13696487788cf25ab4fec4bc4";
//
//		RequestSpecification reqspec = given().basePath(basepath1).baseUri(baseuri1).header("x-api-key", apikey)
//				.header("Content-Type", "application/json").body(userarray);

		Response res=given().baseUri(baseuri1).header("x-api-key", apikey)
				.header("Content-Type", "application/json").when().body(userarray).post(endpoint);
		
		
		res.prettyPrint();

		Assert.assertEquals(res.getStatusCode(), 201);

	}

}
