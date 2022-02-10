package com.infa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {
	
	public static void main(String args[]) throws Exception {
		
		List<Employee> empList = Employee.getAllEmployees();
		
		List<String> firstList = empList.stream().map(employee -> employee.getFirstName().toUpperCase()).collect(Collectors.toList());
		System.out.println(firstList);
		
		List<String> phones = empList.stream().flatMap(employee-> employee.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(phones);
		
		Map<String,String> m1= new HashMap<String, String>();
		m1.put("k", "k1");
		m1.put("k", "k2");
		m1.put("p", "p1");
		m1.put("x", "x1");
		m1.put("z", "z1");
		
		Map m2 = m1.entrySet().stream().filter(k->m1.containsKey("k")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(m2);
		m3 = Collectors.toMap("", "");
		
		empList.stream().map(employee-> employee.getFirstName().toUpperCase()).collect(Collectors.toList());
		empList.stream().forEach(e->System.out.println(e.getLastName()));
		System.out.println(empList.stream().map(e-> e.getFirstName()).sorted().collect(Collectors.toList()));
		
		System.out.println(empList.stream().distinct().collect(Collectors.toMap(Employee::getFirstName, Employee::getEmail,(a,b)->{return b;})));
		System.out.println(empList.stream().distinct().collect(Collectors.toMap(Employee::getFirstName, Employee::getEmail,(a,b)->{throw new IllegalStateException("duplicate key found");})));
		
		System.out.println(empList.stream().collect(Collectors.toMap(Employee::getFirstName, Employee::getEmail)));
		Map<String, Employee> map = empList.stream().collect(Collectors.toMap(Employee::getFirstName, Function.identity()));
		System.out.println(map);
	}
}
