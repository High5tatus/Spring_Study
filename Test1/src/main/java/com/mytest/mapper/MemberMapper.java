package com.mytest.mapper;

import com.mytest.dto.MemberDTO;

public interface MemberMapper {
	// 추가
	public void join(MemberDTO member);
	public void joinauth(String userid);

	// 아이디중복확인
	public int idCheck(String id);

	// 로그인체크
	public MemberDTO loginCheck(String id);
	
	public MemberDTO read(String userid);
}
