package com.walmart.user_auth;

import com.walmart.user_auth.domain.User;
import com.walmart.user_auth.repo.UserRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Column;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserAuthApplicationTests {

	private String userName = "testuser";
	private String email = "testuser@gmail.com";
	private String fName = "test";
	private String lName = "user";
	private String userPass = "testuser";
	@Autowired
	UserRepo userRepository;

	@Test
	@Order(1)
	public void testCreateUser(){
		User user = new User();
		user.setFName(fName);
		user.setLName(lName);
		user.setUserName(userName);
		user.setPassword(userPass);
		user.setEmail(email);
		var usrData = userRepository.save(user);
		assertNotNull(userRepository.findById(usrData.getId()).get());
	}

	@Test
	@Order(2)
	public void testLoginUser(){
		var u = userRepository.findByUserNameAndPassword(userName, userPass).get();
		assertNotNull(u);
	}

	@Test
	@Order(3)
	public void testLogout(){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(userPass);
		userRepository.deleteById(userRepository.findByUserNameAndPassword(userName, userPass).get().getId());
		assertTrue(true);
	}
}
