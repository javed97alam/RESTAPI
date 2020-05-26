package com.rest.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

	public static final Contact   Default_Contact = new Contact("Rushi", "http://sample.com", "admin@sample.com");

	public static final ApiInfo Default_Api_Info = new ApiInfo("Simple API","Simple API description", "v2.0", "general terms", "Simple Ltd", "license", "licenseUrl");
	
	private static final Set<String> Default_Produces_And_Consumes =  new HashSet<String>(Arrays.asList("application/json", "application/xml"));

	
	@Bean
	public Docket  api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(Default_Api_Info).produces(Default_Produces_And_Consumes );
	}


}