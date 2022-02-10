package com.infa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Employee {
	
	public Employee(String firstName, String lastName, String email, List<String> phoneNumbers,Integer salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.salary = salary;
	}

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Integer salary;
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	private List<String> phoneNumbers;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public static List<Employee> getAllEmployees(){
		return Arrays.asList(
				new Employee("kiran", "BR", "kbr@infa",Arrays.asList("929","2332"), 10000),
				new Employee("kiran", "BR", "kbr1@infa",Arrays.asList("929","2332"), 10000),
				new Employee("Ram", "one", "ram@infa",Arrays.asList("24324","4452"),20000),
				new Employee("Sham", "two", "sham@infa",Arrays.asList("323","4224"), 30000)
				);
	}

}
