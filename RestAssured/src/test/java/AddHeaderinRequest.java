import static io.restassured.RestAssured.*;
import java.util.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeaderinRequest {
	String baspath = "https://httpbin.org/";
	String endpoint = "post";

	@Test(priority = 1)
	public void requetbody() {
		Map<String, String> map = new HashMap<>();
		map.put("header1", "val1");
		map.put("header2", "val2");
		RequestSpecification reqspec = given();
		// reqspec.header("key1","val1");
		reqspec.headers(map);
		reqspec.log().headers();
		reqspec.baseUri(baspath);
		reqspec.when().get(endpoint);
		
		Response res=reqspec.get();
		System.out.println(res.getStatusLine());

	}
}
