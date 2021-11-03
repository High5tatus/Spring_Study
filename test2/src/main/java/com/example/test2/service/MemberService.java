package com.example.test2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test2.model.Member;
import com.example.test2.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	//아이디 중복확인
	public Member idCheck(String username) {
		// TODO Auto-generated method stub
		Member check = memberRepository.findByUsername(username);
		return check;
	}	
	
	//추가
	@Transactional
	public void save(Member member) {
		memberRepository.save(member);
	}
	//전체보기
	public List<Member> list(){
		return memberRepository.findAll();
	}
	//삭제
	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	//상세보기(Optional)
	public Member detail(Long id) {
		return memberRepository.findById(id).get();
	}
	//전체보기 페이징
	public Page<Member> list(Pageable pageable){
		return memberRepository.findAll(pageable);
	}
}
