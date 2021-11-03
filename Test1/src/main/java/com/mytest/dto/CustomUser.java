package com.mytest.dto;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class CustomUser extends User{
	
	private MemberDTO member;
	public CustomUser(MemberDTO vo) {
		super(vo.getUserid(),
			  vo.getUserpw(),
			  vo.getAuthList().stream().map(auth->new SimpleGrantedAuthority(auth.getAuth()))
			  .collect(Collectors.toList())
			  );
		this.member = vo;
	}
}
