package com.nutritionist.api_control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiControlApplication.class, args);
		System.out.println("ApiService Started At: http://localhost:9002");

	}

}
