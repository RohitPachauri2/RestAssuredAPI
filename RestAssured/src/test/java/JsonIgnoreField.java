import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class JsonIgnoreField {
	
	
	String baspath = "https://httpbin.org/";
	String endpoint = "post";
	String data;

	/**
	 * POJO EMPLOYEE CLASS TO JSON OBJECT:---------------------
	 * 
	 * @throws JsonProcessingException
	 */

	@Test(priority = 1)
	public void CreateEmployeeObject() throws JsonProcessingException {
		System.out.println("POJO TO JSON OBJECT:---------------------------------");
		ObjectMapper objmap = new ObjectMapper();
		Employee emp = new Employee();
		emp.setFirstname("rohit");
		emp.setGender("M");

		/**
		 * setting jsonignore or jsonignoreproperties annotation in lastname so that lastname field is not
		 * visible(this is done in POJO Class-Employee)
		 */
		emp.setLastname("Pachauri");
		emp.setAge(15);
		emp.setSalary(38900);

		String JsonStringValue = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

		System.out.println(JsonStringValue);
		data = JsonStringValue;
		
		
		/**
		 *  Sending json object to api for testing:-------------
		 */
		
		Response res=given()
				.baseUri(baspath)
				.body(data)
				.header("Content-Type","application/json")
				.when().post(endpoint);
		
		res.prettyPrint();

	}
	
	
	/**
	 * JSON OBJECT TO POJO EMPLOYEE CLASS
	 */
	
	@Test(priority=2)
	public void CreateEmployeeClass()throws JsonProcessingException{
		System.out.println("JSON OBJECT TO POJO OBJECT:--------------------------------");
		ObjectMapper objmap = new ObjectMapper();
		if(data==null) {
			System.out.println("answer is null");
		}
		else {
		Employee emp=objmap.readValue(data, Employee.class);
		System.out.println(emp.getFirstname()+":"+emp.getLastname()+":"+emp.getAge()+":"+emp.getGender()+":"+emp.getSalary());
		}
	
		
	}
	

}
