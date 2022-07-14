package com.weatherapp.user.controller;

import javax.validation.Valid;

import com.weatherapp.user.dto.UserDTO;
import com.weatherapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weatherapp.user.common.messages.BaseResponse;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = { "/add" })
	public ResponseEntity<BaseResponse> createOrUpdateItem(@Valid @RequestBody UserDTO userDTO) {
		BaseResponse response = userService.createUser(userDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = { "/password" })
	public ResponseEntity<BaseResponse> updatePassword(@Valid @RequestBody UserDTO userDTO) {
		BaseResponse response = userService.updatePassword(userDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = { "/update" })
	public ResponseEntity<BaseResponse> updateUser(@Valid @RequestBody UserDTO userDTO) {
		BaseResponse response = userService.up.updateUser(userDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
