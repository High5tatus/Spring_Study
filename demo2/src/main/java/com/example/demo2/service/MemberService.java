package com.example.demo2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo2.model.JpaMember;
import com.example.demo2.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	//추가
	@Transactional
	public void save(JpaMember member) {
		memberRepository.save(member);
	}
	//전체보기
	public List<JpaMember> list(){
		return memberRepository.findAll();
	}
	//삭제
	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	//상세보기(Optional)
	public JpaMember detail(Long id) {
		return memberRepository.findById(id).get();
	}
	//수정
	@Transactional
	public void update(JpaMember member) {
		JpaMember m = memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setName(member.getName());
	}
	//전체보기 페이징
	public Page<JpaMember> list(Pageable pageable){
		return memberRepository.findAll(pageable);
	}
}
