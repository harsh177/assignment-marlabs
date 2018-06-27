package com.examples;

import java.io.Serializable;
import java.util.stream.Stream;

public class Eg6IntersectionType {
	public static void main(String[] args) {
		 Runnable job = new Eg6IntersectionType().create();
		    Stream.of(job.getClass().getInterfaces())
		        .map(Class::getName)
		        .forEach(System.out::println);
		 
		 NonFunction nonF = (NonFunction & Calculator)(e,f)->e+f;
		 
	}
		
	public Runnable create() {
	    return (Runnable & Serializable & A) () ->
	        System.out.println("Hello World");
	}
}

@FunctionalInterface
interface Calculator{
  long calculate(long x, long y);
}

interface  NonFunction{
}

interface A{
 
}