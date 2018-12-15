package com.nenerbener;

public class Client {

	public static void main(String[] args) {

		Employee eRef = new Employee(101, "John Watson", "Redwood Shores");

		System.out.println(eRef.toString());
		System.exit(0);
	}

}
