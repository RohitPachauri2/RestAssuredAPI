import org.assertj.core.util.Arrays;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.response.Response;

import com.fasterxml.jackson.databind.SerializationFeature;
import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.Map.Entry;

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
			String Userdetailsinstring = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(Userdetails);
			System.out.println("User details: " + Userdetailsinstring);

			String firstname = Userdetails.get("firstName").asText();
			System.out.println("firstname is: " + firstname);
			String programmingskill = Userdetails.get("skills").get("Programming Language").asText();
			System.out.println("programming skill is: " + programmingskill);

			Iterator<String> keys = Userdetails.fieldNames();
			System.out.println("All the fields:------------------------------------");
			while (keys.hasNext()) {
				System.out.println(keys.next());
			}
			
			Iterator<JsonNode> values = Userdetails.elements();
			System.out.println("All the values:------------------------------------");
			while(values.hasNext()) {
				System.out.println(values.next());
			}
			
			System.out.println("All the fields and values:------------------------------------");
			Iterator<Entry<String, JsonNode>> keyvaluepair=Userdetails.fields();
			while(keyvaluepair.hasNext()) {
				Entry<String,JsonNode>node=keyvaluepair.next();
				System.out.println(node.getKey()+" : "+node.getValue());
			}
			
			//Removing node "age" from this objectmapper userdetails----
			
			Userdetails.remove("age");
			System.out.println(" ");
			System.out.println("All the fields and values after removing age:------------------------------------");
			Iterator<Entry<String, JsonNode>> keyvaluepairremove=Userdetails.fields();
			while(keyvaluepairremove.hasNext()) {
				Entry<String,JsonNode>node=keyvaluepairremove.next();
				System.out.println(node.getKey()+" : "+node.getValue());
			}
			
			
			//updating node"first name" from "rohit" to "rohitagain"-------------
			Userdetails.put("firstName", "rohitagain");
			System.out.println(" ");
			System.out.println("All the fields and values after updating firstname:------------------------------------");
			Iterator<Entry<String, JsonNode>> keyvaluepairupdate=Userdetails.fields();
			while(keyvaluepairupdate.hasNext()) {
				Entry<String,JsonNode>node=keyvaluepairupdate.next();
				System.out.println(node.getKey()+" : "+node.getValue());
			}
			
			
			
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
