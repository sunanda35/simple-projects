package com.nutritionist.user_authentication;

import com.nutritionist.user_authentication.domain.User;
import com.nutritionist.user_authentication.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserAuthenticationApplicationTests {
	@Autowired
	UserRepository userRepository;

	private String userName = "testuser";
	private String email = "testuser@gmail.com";
	private String userPass = "testuser";

	@Test
	@Order(1)
	public void testCreateUser(){
		User user = new User();
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
