package demo.boot;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import demo.boot.plugin.EmailAnnotationPlugin;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import({BeanValidatorPluginsConfiguration.class,SpringDataRestConfiguration.class})
public class SwaggerConfig {

	@Bean
	public Docket api() {                
		  return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                    .apis(RequestHandlerSelectors.any())
	                    .paths(PathSelectors.any())
	                .build();
	}
	 
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "My REST API", 
	      "Some custom description of API.", 
	      "Intsol API", 
	      "Terms of service", 
	      new Contact("Venkata Ramana", "www.venkataramana.com", "boss@venkataramana.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	

	}
	
	  @Bean
	    UiConfiguration uiConfig() {
	        return UiConfigurationBuilder.builder()
	                .deepLinking(true)
	                .displayOperationId(false)
	                .defaultModelsExpandDepth(1)
	                .defaultModelExpandDepth(1)
	                .defaultModelRendering(ModelRendering.EXAMPLE)
	                .displayRequestDuration(false)
	                .docExpansion(DocExpansion.NONE)
	                .filter(false)
	                .maxDisplayedTags(null)
	                .operationsSorter(OperationsSorter.ALPHA)
	                .showExtensions(false)
	                .tagsSorter(TagsSorter.ALPHA)
	                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
	                .validatorUrl(null)
	                .build();
	  }
	  
	  @Bean
	    public EmailAnnotationPlugin emailPlugin() {
	        return new EmailAnnotationPlugin();
	    }
	  
}