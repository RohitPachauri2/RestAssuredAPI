import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.response.Response;

import com.fasterxml.jackson.databind.SerializationFeature;
import static io.restassured.RestAssured.*;
public class JacksonAPIObject {
	String baseuri1 = "https://reqres.in/";
	String basepath1 = "api/users";
	String apikey = "reqres_7e7d83a13696487788cf25ab4fec4bc4";

	@Test
	public void createuserjacksonapiJSONOBJECT() {

		ObjectMapper objmap = new ObjectMapper();

		ObjectNode Userdetails = objmap.createObjectNode();

		Userdetails.put("firstName", "rohit");
		Userdetails.put("lastName", "pachauri");
		Userdetails.put("age", "23");
		
		ObjectNode Skills = objmap.createObjectNode();
		Skills.put("Programming Language", "Python,Java");
		Skills.put("Automation skills", "selenium");
		
		Userdetails.set("skills", Skills);
		try {
		String Userdetailsinstring=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(Userdetails);
		System.out.println("User details: "+Userdetailsinstring);
		
		String firstname=Userdetails.get("firstName").asText();
		System.out.println("firstname is: "+firstname);
		String programmingskill=Userdetails.get("skills").get("Programming Language").asText();
		System.out.println("programming skill is: "+programmingskill);
		
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
