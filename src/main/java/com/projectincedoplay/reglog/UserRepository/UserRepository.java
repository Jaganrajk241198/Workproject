package com.projectincedoplay.reglog.UserRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.projectincedoplay.reglog.UserEntitya.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByEmailId(String email);

	public User findByEmailIdAndPassword(String email,String password);

}
