package com.rest.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SimpleController {

	
	
	
	@GetMapping("/simple")
	public String getMessage()
	{
		
		return "Presentation Tier...." ;
	}
}
