package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Eg1Predicate {
	public static void main(String[] args) {
		Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");
         
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        System.out.println(filterEmployee(employees, isAdultMale()));
        
        System.out.println(filterEmployee(employees, isAdultFemale()));
        
        System.out.println(filterEmployee(employees, isAgeMoreThan(25)));
        
        System.out.println(filterEmployee(employees, isAgeMoreThan(25).negate()));
        
        System.out.println(filterEmployee(employees, isAdultMale().or(isAdultFemale())));

	}
	
	public static List<Employee> filterEmployee(List<Employee> employees,Predicate<Employee> p1){
		return employees.stream().filter(p1).collect(Collectors.toList());
	}
	
	public static Predicate<Employee> isAdultMale(){
		return e->e.getAge()>21 && e.getGender().equalsIgnoreCase("M");
	}
	
	public static Predicate<Employee> isAdultFemale(){
		return e->e.getAge()>18 && e.getGender().equalsIgnoreCase("F");
	}
	
	public static Predicate<Employee> isAgeMoreThan(Integer age){
		return e->e.getAge()>age;
	}
}
