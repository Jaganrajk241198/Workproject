package com.projectincedoplay.reglog;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.projectincedoplay.jwtutils.Jwtutils;
import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserPojo.UserPojo;
import com.projectincedoplay.reglog.UserRepository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Jwtutils jwtutil;

	@Autowired
	private WebClient webClient;

	public String saveUser(UserPojo userPojo) {

		Optional<User> email = userRepository.findByEmailId(userPojo.getEmail());

		if (!email.isPresent()) {

			User user = new User();
			user.setName(userPojo.getName());
			user.setEmailId(userPojo.getEmail());
			user.setPassword(userPojo.getPassword());
			userRepository.save(user);
			return "Successfully Entered";

		}

		else {
			return "This email is already register";

		}

	}

	

	@Override
	public List<User> findByEmailid(String email) {
		// TODO Auto-generated method stub
		List<User> Emailid = userRepository.findByEmailId(email).stream().collect(Collectors.toList());
		return Emailid;
	}

	@Override
	public String authenticate(UserPojo userPojo) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmailIdAndPassword(userPojo.getEmail(), userPojo.getPassword());
		if (user == null) {
			return "Invalid Credentials";

		} else {
			return "Welcome " + user.getName();
		}
	}

	public Mono<String> saveUserNew(UserPojo user) {
		System.out.println(user);
		// if condition have to check session 
		// session implement
		// 80 to 85 else session
		/*
		 * Mono<String> userResponse = webClient.post() .uri("/saveUser")
		 * .body(Mono.just(user),User.class) .retrieve() .bodyToMono(String.class);
		 * 
		 * return userResponse;
		 */
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<UserPojo> entity = new HttpEntity<UserPojo>(user);
		String url = "http://localhost:8081/" + user.getEmail();
		System.out.println(url);
	//	String body = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		//System.out.println(body);
		
		return null;
		
	
	//generate jwt
	//UserPojo pojo = new UserPojo();
	//String token = jwtutil.generateJwt(pojo);
}



	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
