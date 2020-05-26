package com.rest.example;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class SprintBootMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootMainApplication.class, args);
	}

	@Bean
	public  LocaleResolver   localeResolver()
	{
	SessionLocaleResolver  localResolver = new SessionLocaleResolver();
	localResolver.setDefaultLocale(Locale.US);
	return localResolver;
	}


	@Bean
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource  = new ResourceBundleMessageSource();
	     
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
}
