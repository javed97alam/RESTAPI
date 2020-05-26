package com.example.springcache.domain;

public class Student {
	String id;
	String name;
	String address;

	public Student(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String clz) {
		this.address = address;
	}

}
