package com.mycom.models;

import java.util.HashMap;
import java.util.List;

import com.mycom.vo.PersonVO;

public interface PersonService {
	//추가
	public void insert(PersonVO person);
	//전체보기
	public List<PersonVO> list();
	//전체보기(검색)
	public List<PersonVO> list(HashMap<String, String> hm);
	//상세보기
	public PersonVO view(String id);
	//수정
	public void update(PersonVO person);
	//삭제
	public void delete(String id);
	//개수
	public int count();
	//개수 (검색)
	public int count(HashMap<String, String>hm);
}
