package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRep;
	public void insert(Todo todo) {
		todoRep.save(todo);
	}
	public List<Todo> findAll(){
		return todoRep.findAll();
	}
	
	public List<Todo> findBySubject(String subject){
		return todoRep.findBySubjectContaining(subject);
	}
	
	public void delete(Long num) {
		todoRep.deleteById(num);
	}
	public Optional<Todo> view(Long num) {		
		return todoRep.findById(num);
	}
	@Transactional
	public void update(Todo todo) {
		Todo to =todoRep.findById(todo.getNum()).get();
		to.setName(todo.getName());
		to.setSubject(todo.getSubject());
		to.setSummary(todo.getSummary());
	}
}