package com.myboard.mapper;

import com.myboard.dto.MemberDTO;

public interface MemberMapper {
	// 추가
	public void join(MemberDTO member);

	// 아이디중복확인
	public int idCheck(String id);

	// 로그인체크
	public MemberDTO loginCheck(String id);
}
