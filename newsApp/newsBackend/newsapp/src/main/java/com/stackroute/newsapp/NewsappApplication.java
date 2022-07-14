package com.stackroute.newsapp;

import com.stackroute.newsapp.userservice.model.Role;
import com.stackroute.newsapp.userservice.model.User;
import com.stackroute.newsapp.userservice.model.UserRole;
import com.stackroute.newsapp.userservice.service.UserService;
import com.stackroute.newsapp.userservice.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
public class NewsappApplication{


	public static void main(String[] args) {

		SpringApplication.run(NewsappApplication.class, args);
		System.out.println("Server Running at: http://localhost:8080");
	}


}
