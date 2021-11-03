package com.example.test2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test2.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	public Member findByUsername(String username);
}
