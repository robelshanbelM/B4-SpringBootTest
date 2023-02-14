package com.swaggerwith.spring.springDocSwagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class config  extends WebMvcConfigurerAdapter {

	
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {

	        System.out.println("******************************Configuring swagger resource handler");
	        registry.addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");
	        registry.addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }
	
	
	@Bean
	
	public Docket docket() {
		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.swaggerwith.spring.controller"))
				 .build().apiInfo(metaData());
		
		
		
		
		
		
	}
	
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Google Map Api Spring Boot Swagger Docs")
                .description("\"Swagger configuration for application \"")
                .version("1.2.0")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
	
	
	
	
	
}