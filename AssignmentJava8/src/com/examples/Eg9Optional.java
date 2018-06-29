package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Rules to Use Optional
/*
1. Collection Wrapper - Bad Idea 
   > the rule doesn’t apply when the output is a collection or an array. 
   In a case when there’s no element to return, an empty instance is superior to empty Optional and null 
   as it conveys all necessary information. 
   Optional doesn’t provide any additional value and only complicates client code, hence it should be avoided
	
	BadCode
	Optional<List<Item>> itemsOptional = getItems();
	if (itemsOptional.isPresent()) { // do we really need this?
	    itemsOptional.get().forEach(item -> {
	        // process item
	    });
	} else {
	    // the result is empty
	}

2. Do not declare any instance variable of type Optional.
3. Use null to indicate optional data within the private scope of a class.
4. Use Optional for getters that access the optional field.
5. Do not use Optional in setters or constructors.
6. Use Optional as a return type for any other business logic methods that have an optional result.	

Examples
 // normal getters of pojo
    public String getAddressLine() { return addressLine; }
    public String getCity() { return city; }

    // special getter for optional field
    public Optional<String> getPostcode() {
      return Optional.ofNullable(postcode);
    }

    // return optional instead of null for business logic methods that may not find a result
    public static Optional<Address> findAddress(String userInput) {
      return ... // find the address, returning Optional.empty() if not found
    }

*/
public class Eg9Optional {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
		Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
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

		Eg9Optional s = new Eg9Optional();

		System.out.println(s.check(null));

		System.out.println(s.getEmployeeNameById(employees, 21));

	}

	// ifPresent is identicle to if(isPresent())

	private String getEmployeeNameById(List<Employee> employees, int id) {
		Optional<Employee> opt = employees.stream().filter(e -> e.getId() == id).findFirst();
		// return opt.isPresent() ? opt.get().getFirstName() : "ERROR";
		// return opt.map(Employee::getFirstName).orElse("ERROR");
		// return opt.map(Employee::getFirstName).orElseGet(()->"ERROR");
		// return opt.map(this::get).orElseThrow(()->new CustomException("Data Not
		// Present"));
		return opt.map(Employee::getFirstName).orElseThrow(CustomException::new);
	}

	public String check(String n) {
		return Optional.ofNullable(n).orElse("Error");
	}

	public String get(Employee n) {
		return n.getFirstName();
	}

}

class CustomException extends RuntimeException {
	private String message;

	CustomException() {
		this.message = "Exception";
	}

	CustomException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "CustomException [message=" + message + "]";
	}

}