import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;
public class xmldata {
	String baseuri="https://petstore.swagger.io/";
	String endpoint="v2/store/order/1";
	@Test
	public void getpetxml() {
		RequestSpecification rs=given()
				.baseUri(baseuri).
				basePath(endpoint).
				header("accept","application/xml");
				
		Response res=rs.get();
		System.out.println(res.asPrettyString());
		
		res.then().body("Order[0].status", Matchers.equalTo("placed"));
		
		XmlPath xp=new XmlPath(res.asString());
		List<String>vals=xp.getList("Order.");
		for(String x:vals) {
			System.out.println(x+"  ");
			
		}
		

	}

}
