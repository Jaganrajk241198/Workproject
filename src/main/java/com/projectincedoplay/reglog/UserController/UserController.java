package com.projectincedoplay.reglog.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectincedoplay.reglog.UserService;
import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserPojo.UserPojo;

import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getUserDetails")
	public List<User> getUserInfo() {
		return userService.getUser();
	}
	

	@PostMapping("/register")
	public String SetUserInfo(@RequestBody UserPojo pojo) {
		return userService.saveUser(pojo);
	}
	
	
	@PostMapping("/login")
	public Mono<String> UserLogin(@RequestBody UserPojo pojo) {
		
		return userService.saveUserNew(pojo);
	}
	
	@GetMapping("/{emailId}")
	public List<User>getUserInfo(@PathVariable String emailId) {
		
		return userService.findByEmailid(emailId);
	}
}

