package com.example.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@PostMapping("todo/insert")
	public String insert(@RequestBody Todo todo) {
		todoService.insert(todo);
		return "success";
	}
	
//	@GetMapping("todo/list")
//	public List<Todo> list(Model model){
//		return todoService.findAll();
//	}
	@GetMapping("todo/list")
	public List<Todo> list(@RequestParam(required = false) String subject){
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
	public ResponseEntity<Todo> get(@PathVariable Long num) {
		Optional<Todo> todo = todoService.view(num);
		if(todo.isPresent()) {
			return new ResponseEntity<>(todo.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("todo/update/{num}")
	public String update(@PathVariable Long num, @RequestBody Todo todo) {
		todoService.update(todo);
		return "success";
	}
}
