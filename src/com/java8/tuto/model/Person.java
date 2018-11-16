package com.java8.tuto.model;

public class Person {
	private String lastName;
	private String name;
	private int age;
	private int seniority;
	
	public Person(final String name, final String lastName, final int age, final int seniority) {
		this.lastName = lastName;
		this.name = name;
		this.age = age;
		this.seniority = seniority;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
}
