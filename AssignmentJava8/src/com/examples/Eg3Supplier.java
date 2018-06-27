package com.examples;

import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;

public class Eg3Supplier {
	public static void main(String[] args) {
		Supplier<Date> dateSupplier = Eg3Supplier::getDate;
		System.out.println(dateSupplier.get());
		Supplier<String> uuidSupplier = ()-> UUID.randomUUID().toString();
		System.out.println(uuidSupplier.get());
	}
	
	public static Date getDate() {
		return new Date();
	}
}
