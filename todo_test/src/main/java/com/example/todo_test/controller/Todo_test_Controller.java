package com.example.todo_test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_test.model.Todo_test;
import com.example.todo_test.service.Todo_test_Service;

@RestController
public class Todo_test_Controller {
	@Autowired
	private Todo_test_Service todoService;
	
	@PostMapping("todo/insert")
	public String insert(@RequestBody Todo_test todo) {
		todoService.insert(todo);
		return "success";
	}
	
//	@GetMapping("todo/list")
//	public List<Todo> list(Model model){
//		return todoService.findAll();
//	}
	@GetMapping("todo/list")
	public List<Todo_test> list(@RequestParam(required = false) String subject){
		if(subject==null) {
			return todoService.findAll();
		}else {
			return todoService.findBySubject(subject);
		}
	}
	@DeleteMapping("todo/delete/{num}")
	public ResponseEntity<String> delete(@PathVariable Long num) {
		try {
			todoService.delete(num);
			return new ResponseEntity<>("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("todo/get/{num}")
	public ResponseEntity<Todo_test> get(@PathVariable Long num) {
		Optional<Todo_test> todo = todoService.view(num);
		if(todo.isPresent()) {
			return new ResponseEntity<>(todo.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("todo/update/{num}")
	public String update(@PathVariable Long num, @RequestBody Todo_test todo) {
		todoService.update(todo);
		return "success";
	}
}
