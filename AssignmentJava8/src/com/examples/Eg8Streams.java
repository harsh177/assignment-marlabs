package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Eg8Streams {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
		Employee e2 = new Employee(1, 13, "F", "Martina", "Hengis");
		Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
		Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
		Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
		Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
		Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
		Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
		Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
		Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 }));

		System.out.println(employees.stream().filter(e -> e.getAge() > 25).map(e -> e.getId() * 2 + "n")
				.collect(Collectors.toList()));

		System.out.println(employees.stream().reduce((i, j) -> i.getAge() > j.getAge() ? i : j));

		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 4);
		System.out.println(stream1.distinct().collect(Collectors.toList()));

		// to distinct object we need to add code in hashcode and equals
		System.out.println(employees.stream().distinct().collect(Collectors.toList()));

		// convert to set
		System.out.println(employees.stream().map(e -> e.getId()).collect(Collectors.toSet()));

		// sum of ids
		System.out.println(employees.stream().map(e -> e.getId()).collect(Collectors.summingInt(e -> e)) + "");

		// Average of ids
		System.out.println(employees.stream().collect(Collectors.averagingDouble(e -> e.getId())) + "");

		// Count object
		System.out.println(employees.stream().collect(Collectors.counting()) + "");

		// Joiners
		System.out.println(employees.stream().map(e -> e.getFirstName()).collect(Collectors.joining("-", "(", ")")));

		List<String> fruits = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = fruits.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);

		// groupd by id
		System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.counting())));

		// group by id and sum of age
		System.out.println(employees.stream()
				.collect(Collectors.groupingBy(Employee::getId, Collectors.summingInt(Employee::getAge))));
		
		//Mapper
		System.out.println(employees.stream().collect(Collectors.mapping(e->e.getId()*2,Collectors.toList())));

		//group by id and list of name
		System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getFirstName,Collectors.toList()))));
	}
}
