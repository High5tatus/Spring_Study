package com.example.demo3.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo3.model.User;
import com.example.demo3.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{
@Autowired
private UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		User user = userRepository.findByUsername(username);
		System.out.println("user : " + user);
		if(user==null) return null;
		PrincipalDetails puser = new PrincipalDetails(user);
		return puser;
	}
	
}
