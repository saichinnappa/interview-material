package com.practice.java.features.designpatterns.structural.adapter;

public class EmployeeDB implements Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	public EmployeeDB(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	public String toString() {
		return "ID: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Email: " + email;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getFirstName() {
		return null;
	}

	@Override
	public String getLastName() {
		return null;
	}

	@Override
	public String getEmail() {
		return null;
	}
}
