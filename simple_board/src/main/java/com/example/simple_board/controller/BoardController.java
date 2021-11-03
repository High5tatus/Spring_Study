package com.example.simple_board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_board.model.Board;
import com.example.simple_board.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;

	@PostMapping("api/insert")
	public String insert(@RequestBody Board board) {
		boardService.insert(board);
		return "success";
	}
//	@GetMapping("api/get")
//	public List<Board> list(Model model) {
//		return boardService.findAll();
//	}
	@GetMapping("api/get")
	public List<Board> list(@RequestParam(required = false) String title){
		if(title==null) {
			return boardService.findAll();
		}else {
			return boardService.findBySubject(title);
		}
	}
	@DeleteMapping("api/delete/{num}")
	public String delete(@PathVariable Long num) {
		boardService.delete(num);
		return "success";
	}
	@GetMapping("api/get/{num}")
	public ResponseEntity<Board> get(@PathVariable Long num) {
		Optional<Board> todo = boardService.view(num);
		if(todo.isPresent()) {
			return new ResponseEntity<>(todo.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("api/update/{num}")
	public String update(@PathVariable Long num, @RequestBody Board board) {
		boardService.update(board);
		return " success";
	}
	
}
