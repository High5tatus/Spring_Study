package com.example.todo_test.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_test.model.Todo_test;
import com.example.todo_test.repository.Todo_test_repository;


@Service
public class Todo_test_Service {
	@Autowired
	private Todo_test_repository todoRep;
	public void insert(Todo_test todo) {
		todoRep.save(todo);
	}
	public List<Todo_test> findAll(){
		return todoRep.findAll();
	}
	
	public List<Todo_test> findBySubject(String subject){
		return todoRep.findBySubjectContaining(subject);
	}
	
	public void delete(Long num) {
		todoRep.deleteById(num);
	}
	public Optional<Todo_test> view(Long num) {		
		return todoRep.findById(num);
	}
	@Transactional
	public void update(Todo_test todo) {
		Todo_test to =todoRep.findById(todo.getNum()).get();
		to.setName(todo.getName());
		to.setSubject(todo.getSubject());
		to.setSummary(todo.getSummary());
	}
}
