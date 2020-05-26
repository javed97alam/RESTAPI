package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication  //@Configuration , @ComponentScan , @EnableAutoConfiguration
public class Day2OtherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day2OtherServiceApplication.class, args);
	}

   @Bean
	public RestTemplate getForRestTemplate()
	{
		return new RestTemplate();
	}
}
