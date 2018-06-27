package com.examples;

import java.util.function.BiPredicate;

public class Eg5BiPredicate {
public static void main(String[] args) {
	BiPredicate<Integer,Integer> bi = (i,k)-> i > k;
	System.out.println(bi.test(2, 5));
}
}
