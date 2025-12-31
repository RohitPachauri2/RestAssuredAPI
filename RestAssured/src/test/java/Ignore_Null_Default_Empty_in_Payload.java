import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class Ignore_Null_Default_Empty_in_Payload {

	Employee emp;
	@Test
	public void SetDatainPojo() throws JsonProcessingException {
		emp=new Employee();
		emp.setFirstname("rohit");
//		emp.setLastname("pachauri");    here default is null
		emp.setAge(15);
		emp.setGender("Male");
//		emp.setSalary(160000);
		ObjectMapper empobj=new ObjectMapper();
		
		//for removing default keys and values from pojo class we have to use @jsoninclude in pojo class-non default
		//for removing null keys and values from pojo class we have to use @jsoninclude in pojo class-non null
		//for removing empty keys and values from pojo class we have to use @jsoninclude in pojo class-non empty
		String EmpString=empobj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(EmpString);
		
		
	}
	
}
