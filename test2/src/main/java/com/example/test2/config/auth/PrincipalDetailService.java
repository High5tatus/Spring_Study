package com.example.test2.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test2.model.Member;
import com.example.test2.repository.MemberRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{
@Autowired
private MemberRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		Member member = userRepository.findByUsername(username);
		System.out.println("user : " + member);
		if(member==null) return null;
		PrincipalDetails puser = new PrincipalDetails(member);
		return puser;
	}
	
}
