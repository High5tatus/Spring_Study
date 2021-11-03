package com.mytest.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.dto.MemberDTO;
import com.mytest.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper mMapper;
	
	@Override
	public void join(MemberDTO member) {
		mMapper.join(member);
		mMapper.joinauth(member.getUserid());
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return mMapper.idCheck(id);
	}

	@Override
	public MemberDTO loginCheck(String id) {
		// TODO Auto-generated method stub
		return mMapper.loginCheck(id);
	}

}
