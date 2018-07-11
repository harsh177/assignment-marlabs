package com.examples;

enum Week {
	Sunday(1),
	Monday(2),
	Tuesday(3),
	Wednesday(4),
	Thursday(5),
	Friday(6),
	Saturday(7);
	
	private int day;
	
	Week(int day){
		this.day=day;
	}
	
	public int getDay() {
		return this.day;
	}
}

enum Season{SUMMER,WINTER,SPRING,FALL}
public class Eg11Enum{
	public static void main(String[] args) {
		for(Week w:Week.values()) {
			System.out.println(w+" , "+w.getDay());
		}
		System.out.println(Week.Monday.getDay());
		Season s = Season.SPRING;
		System.out.println(s);
	}
}