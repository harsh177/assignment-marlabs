package com.examples;

/*
Type-1
method1(ArrayList<String> l1);
You can pass array list of only string type
In this method you can read and write both

Type-2
method1(ArrayList<?> l1)
you can pass array list of any type
In this method you can not add anything except null and this method is best suitable for readonly

Type-3
method1(ArrayList<? extends X> l1)
if X is class then you can pass array list of either X type or array list of child class of X
if X is interface then you can pass array list of either X type or array list of implemented class of X
In this method you can not add anything except null and this method is best suitable for readonly

Type-4
method1(ArrayList<? super X> l1)
if X is class then you can pass array list of either X type or array list of super class of X
if X is interface then you can pass array list of either X type or array list of super class of implemented class of X
In this method you can add X type

ArrayList<String> l=new ArrayList<String>(); //valid
ArrayList<Integer> l=new ArrayList<Integer>(); //valid
ArrayList<? extends Number> l=new ArrayList<Integer>(); //valid
ArrayList<? super Object> l=new ArrayList<String>(); //valid

ArrayList<?> l=new ArrayList<?>(); //invalid
ArrayList<?> l=new ArrayList<? extends String>(); //invalid

wild card is allowed only at assignment side.

*/

public class Eg12Generics {
	public static void main(String[] args) {

	}
}
