import java.util.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import io.restassured.*;

import static io.restassured.RestAssured.*;

public class xmldatapost {
String baseuri="https://petstore.swagger.io/";
String endpoint="v2/pet";
String jsonbody="{\r\n"
		+ "  \"id\": 0,\r\n"
		+ "  \"category\": {\r\n"
		+ "    \"id\": 0,\r\n"
		+ "    \"name\": \"string\"\r\n"
		+ "  },\r\n"
		+ "  \"name\": \"doggie\",\r\n"
		+ "  \"photoUrls\": [\r\n"
		+ "    \"string\"\r\n"
		+ "  ],\r\n"
		+ "  \"tags\": [\r\n"
		+ "    {\r\n"
		+ "      \"id\": 0,\r\n"
		+ "      \"name\": \"string\"\r\n"
		+ "    }\r\n"
		+ "  ],\r\n"
		+ "  \"status\": \"available\"\r\n"
		+ "}";

String xmlbody="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
		+ "<Pet>\r\n"
		+ "	<id>0</id>\r\n"
		+ "	<Category>\r\n"
		+ "		<id>0</id>\r\n"
		+ "		<name>string</name>\r\n"
		+ "	</Category>\r\n"
		+ "	<name>doggie</name>\r\n"
		+ "	<photoUrls>\r\n"
		+ "		<photoUrl>string</photoUrl>\r\n"
		+ "	</photoUrls>\r\n"
		+ "	<tags>\r\n"
		+ "		<Tag>\r\n"
		+ "			<id>0</id>\r\n"
		+ "			<name>string</name>\r\n"
		+ "		</Tag>\r\n"
		+ "	</tags>\r\n"
		+ "	<status>available</status>\r\n"
		+ "</Pet>";
@Test
public void getxmldata() {
RequestSpecification xmlreq=given().baseUri(baseuri)
.basePath(endpoint).header("Content-Type", "application/json")
.header("accept","application/xml")
.body(jsonbody);

Response res=xmlreq.post();
System.out.println(res.prettyPrint());
System.out.println(res.getStatusLine());
}
@Test
public void senxmldata() {
RequestSpecification xml=given().baseUri(baseuri)
			.basePath(endpoint).header("Content-Type", "application/xml")
			.header("accept","application/xml")
			.body(xmlbody);

			Response res=xml.post();
			System.out.println(res.prettyPrint());
			System.out.println(res.getStatusLine());
			res.then().body("Pet.name", Matchers.equalTo("doggie"));
	
}










}
