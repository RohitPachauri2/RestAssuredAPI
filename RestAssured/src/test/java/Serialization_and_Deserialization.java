import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Serialization_and_Deserialization {
	Employee emp;
	String baspath = "https://httpbin.org/";
	String endpoint = "post";
	String data;

	@Test(priority = 1)
	public void CreatEempJsonFromEmpClass() throws JsonProcessingException {

		// Serialization EMP OBJECT--->EMP JSON
		emp = new Employee();
		emp.setAge(35);
		emp.setFirstname("rohit");
		emp.setLastname("sharma");
		emp.setGender("M");
		emp.setSalary(35000.09);

		ObjectMapper objmapper = new ObjectMapper();

		String JsonValueAsString = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println("Full value: " + JsonValueAsString);
		data = JsonValueAsString;
		
		

		// Deserialization EMP JSON--->EMP OBJECT

		Employee emp2 = objmapper.readValue(JsonValueAsString, Employee.class);

		System.out.println("Age: " + emp2.getAge());
		System.out.println("Name: " + emp2.getFirstname() + " " + emp2.getLastname());
		System.out.println("Gender: " + emp2.getGender());
		System.out.println("Salary: " + emp2.getSalary());

	}

	@Test(priority = 2)
	public void SentEmpJsonCreated() throws JsonProcessingException {

		Response res = given().baseUri(baspath).body(data).header("Content-Type", "application/json").when()
				.post(endpoint);

		res.prettyPrint();
		System.out.println(res.statusLine());
		Assert.assertEquals(200, res.getStatusCode());

	}

}
