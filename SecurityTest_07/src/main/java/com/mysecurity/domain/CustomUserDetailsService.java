package com.mysecurity.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mysecurity.dto.CustomUser;
import com.mysecurity.dto.MemberDTO;
import com.mysecurity.mapper.MemberMapper;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		MemberDTO member = memberMapper.read(username);
		
		return member==null? null : new CustomUser(member);
	}

}
