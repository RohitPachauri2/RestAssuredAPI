import java.util.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import static io.restassured.RestAssured.*;

public class QueryRequestSpecification {

	String baseuri = "https://reqres.in/";
	String endpoint = "/api/users";
	String data="{\"name\":\"rohit\",\"role\":\"leader\"}";
	@Test
	public void requestspecification() {
		Response res=given().baseUri(baseuri)
				.header("Content-Type","application/json").body(data).header("x-api-key","reqres_7e7d83a13696487788cf25ab4fec4bc4").when().post(endpoint);
		
		System.out.println(res.getBody().asString());
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusLine());
		
		RequestSpecification requestSpec = given()
		        .baseUri(baseuri)
		        .basePath(endpoint)
		        .header("Content-Type", "application/json").header("x-api-key","reqres_7e7d83a13696487788cf25ab4fec4bc4")
		        .body(data);
		
		QueryableRequestSpecification qrs=SpecificationQuerier.query(requestSpec);
		System.out.println(qrs.getBasePath());
		System.out.println(qrs.getBaseUri());
		System.out.println(qrs.getHeaders());
		System.out.println("Headers:------------------------------------------------");
		for(Header x:qrs.getHeaders()) {
			System.out.println(x);
		}
		
		
	}

}
