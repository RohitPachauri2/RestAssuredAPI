import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_DEFAULT)
//@JsonInclude(Include.NON_NULL)
@JsonInclude(Include.NON_EMPTY)
public class Employee {
private String firstname;
private String lastname;
private String gender;
private int age;	
private double salary;
private String[] arr;
private Map<String,String>map;

public Map<String, String> getMap() {
	return map;
}



public void setMap(Map<String, String> map) {
	this.map = map;
}



public String getFirstname() {
	return firstname;
}



public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String[] getarr() {
	return arr;
}



public void setarr(String[] arr) {
	this.arr = arr;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public double getSalary() {
	return salary;
}


public void setSalary(double salary) {
	this.salary = salary;
}



}
