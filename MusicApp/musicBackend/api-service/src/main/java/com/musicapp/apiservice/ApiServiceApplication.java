package com.musicapp.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
		System.out.println("Music ApiService Started At: http://localhost:8081");
	}

}
