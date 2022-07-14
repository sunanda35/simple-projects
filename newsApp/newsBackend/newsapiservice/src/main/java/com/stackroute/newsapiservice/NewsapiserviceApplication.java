package com.stackroute.newsapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class NewsapiserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsapiserviceApplication.class, args);


		System.out.println("Server Running at: http://localhost:8082");

	}


}
