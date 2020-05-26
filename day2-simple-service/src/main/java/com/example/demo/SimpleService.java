package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleService {

	@GetMapping("/")
	public String getMsg()
	{
		return "Faith";
	}
}
