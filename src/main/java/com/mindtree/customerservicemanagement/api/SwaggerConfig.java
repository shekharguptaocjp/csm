package com.mindtree.customerservicemanagement.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mindtree.customerservicemanagement"))
				.paths(PathSelectors.any()).build().apiInfo(metaInfo());
	}  
	private ApiInfo metaInfo()
	{
		ApiInfo apiInfo=new ApiInfo("Spring Boot Swagger Example", "Spring Boot Swagger Example", "1.0", "", new Contact("","",""), "", "");
		return apiInfo;
	}

}
