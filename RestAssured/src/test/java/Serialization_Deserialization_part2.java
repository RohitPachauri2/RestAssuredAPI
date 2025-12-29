import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Serialization_Deserialization_part2 {
Nested_Employee ne;
Address address;

@Test
	public void SerDesJson() throws JsonProcessingException {
		
		address=new Address();
		ne=new Nested_Employee();
		
		address.setstreet("greater noida");
		address.setCity("noida");
		address.setState("Uttar Pradesh");
		address.setPincode(201315);
		
		ne.setAge(15);
		ne.setFirstname("rohit");
		ne.setLastname("pachauri");
		ne.setAddress(address);
		
		ObjectMapper nestedemp=new ObjectMapper();
		
		//Serialization------------------------------------------------
		
		String Strnesstedempval=nestedemp.writerWithDefaultPrettyPrinter().writeValueAsString(ne);
		System.out.println(Strnesstedempval);
		
		
		//Deserialization-----------------------------------------------
		
		Nested_Employee ne1=nestedemp.readValue(Strnesstedempval, Nested_Employee.class);
		Address ad1=ne1.getAddress();
		System.out.println(ne1.getFirstname()+" : "+ne1.getLastname()+" : "+ne1.getAge()+" : "+ad1.toString());
		
		
	}
	
}
