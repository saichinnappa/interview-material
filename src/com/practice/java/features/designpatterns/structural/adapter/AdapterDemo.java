package com.practice.java.features.designpatterns.structural.adapter;

import java.util.List;

public class AdapterDemo {

	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();

		//From end users perspective we are fetching employees
		//underneath, we are fetching from a DB and Ldap
		List<Employee> employees = client.getEmployeeList();
		
		System.out.println(employees);
	}
}
