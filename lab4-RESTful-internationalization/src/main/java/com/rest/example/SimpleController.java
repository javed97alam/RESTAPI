package com.rest.example;



import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

@Autowired
MessageSource messageSource;

@RequestMapping(method = RequestMethod.GET,path = "/disp")
//@GetMapping (path="/disp")
public String disp()
{
  return "Simple Controller";	
}


@GetMapping (path="/dispBean")
public SimpleBean  dispBean()
{
	return new SimpleBean("SimpleBean");
}


@GetMapping (path="/dispBean/{name}")
public SimpleBean  dispBeanPathVariable(@PathVariable String name)
{
	return new SimpleBean(String.format("SimpleBean %s", name));
}

@GetMapping (path="/dispInternationalized")
public String  dispInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)
{
	return messageSource.getMessage("simple.message",  null, locale);
}

}
