package com.mysecurity.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mytest.dto.CustomUser;
import com.mytest.dto.MemberDTO;
import com.mytest.mapper.MemberMapper;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername :" +username);
		MemberDTO member = memberMapper.read(username);
		System.out.println(member);
		
		return member==null? null : new CustomUser(member);
	}

}
