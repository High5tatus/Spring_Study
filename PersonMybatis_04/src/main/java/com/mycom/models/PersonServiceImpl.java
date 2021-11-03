package com.mycom.models;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.vo.PersonVO;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAOImpl dao;
	
	@Override
	public void insert(PersonVO person) {
		dao.dao_insert("insertPerson", person);
		
	}

	@Override
	public List<PersonVO> list() {		
		return dao.dao_list("allPerson");
	}

	@Override
	public List<PersonVO> list(HashMap<String, String> hm) {
		return dao.dao_list("listPerson", hm);
	}

	@Override
	public PersonVO view(String id) { //viewPerson
		
		return dao.dao_view("viewPerson", id);
	}

	@Override
	public void update(PersonVO person) { //updatePerson
		dao.dao_update("updatePerson", person);
		
	}

	@Override
	public void delete(String id) { //deletePerson
		dao.dao_delete("deletePerson", id);
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.dao_count("allCount");
	}

	@Override
	public int count(HashMap<String, String> hm) {
		return dao.dao_count("listCount", hm);
	}

}
