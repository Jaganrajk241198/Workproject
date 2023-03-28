package com.projectincedoplay.reglog;

import java.util.List;
import java.util.Optional;

import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserPojo.UserPojo;

import reactor.core.publisher.Mono;


public interface UserService {

	public List<User> getUser();

	public String saveUser(UserPojo pojo);
	
	public List <User> findByEmailid(String email);
	
	public String authenticate(UserPojo userPojo);

	public Mono<String> saveUserNew(UserPojo pojo);
	

	
}

