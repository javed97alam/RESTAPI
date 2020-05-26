package com.rest.example;

public class SimpleBean {

	private String message;
	
	public SimpleBean(String msg)
	{
		message = msg;
	}

	// If this method is commented error will come
	public String getMessage() {
		return message;
	}
	
	
		
}
