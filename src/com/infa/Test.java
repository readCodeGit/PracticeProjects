package com.infa;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	public static void main (String args[]) {
		
		String  str [] = new String[] {"Kiran","Infa","Bay Area"};
		Stream<String> stream = Arrays.stream(str);
		
		System.out.println(Arrays.stream(str).anyMatch(a -> a.contains("e")));
		
		List<String> s = Arrays.stream(str).filter(e->e.equals("Kiran")).collect(Collectors.toList());
		System.out.println(s);
		
		List<Employee> empList = Employee.getAllEmployees();

		//Map functions
		List<String> nameList = empList.stream().map(element-> element.getFirstName()).collect(Collectors.toList());
		System.out.println("name list of all employees : " + nameList);
		
		List<List<String>> mapphones = empList.stream().map(emp -> emp.getPhoneNumbers()).collect(Collectors.toList());
			System.out.println(mapphones);
		
		//flatmap functions
		List<String> flatphones = empList.stream().flatMap(emp -> emp.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(flatphones);
		
		
		 List<List<String>> namesNested = Arrays.asList( 
			      Arrays.asList("Jeff", "Bezos"), 
			      Arrays.asList("Bill", "Gates"), 
			      Arrays.asList("Mark", "Zuckerberg"));

			    List<String> namesFlatStream = namesNested.stream()
			      .flatMap(Collection::stream)
			      .collect(Collectors.toList());
			    
		System.out.println(namesFlatStream);

		empList.stream().flatMap(emp -> emp.getPhoneNumbers().stream()).forEach(e->System.out.println(e));
		
		System.out.println("Reduce function sum : "+empList.stream().map(element -> element.getSalary()).reduce(0,Integer::sum));
		
		//partition by
		 List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
		    Map<Boolean, List<Integer>> isEven = intList.stream().collect(
		      Collectors.partitioningBy(i -> i % 2 == 0));
		    System.out.println(isEven);
		
	}
}
