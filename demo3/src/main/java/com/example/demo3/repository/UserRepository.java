package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	public User findByUsername(String username);
}
