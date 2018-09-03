package com.mindtree.customerservicemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({"com.mindtree.customerservicemanagement"})

public class CustomerServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceManagementApplication.class, args);
	}
}
