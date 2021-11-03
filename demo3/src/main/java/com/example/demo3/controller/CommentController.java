package com.example.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.config.auth.PrincipalDetails;
import com.example.demo3.model.Board;
import com.example.demo3.model.Comment;
import com.example.demo3.service.CommentService;

@RequestMapping("/reply/*")
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("insert/{num}")
	public ResponseEntity<String> insert(@PathVariable Long num, @RequestBody Comment comment,  @AuthenticationPrincipal PrincipalDetails principal ) {
		Board b = new Board();
		b.setNum(num);
		comment.setBoard(b);//board
		System.out.println("principal.getUser() : " + principal.getUser());
		comment.setUser(principal.getUser()); // user
		commentService.insert(comment);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	@GetMapping("list/{num}")
	public List<Comment> List(@PathVariable Long num) {
		List<Comment> clist = commentService.list(num);
		return clist;
	}
	@DeleteMapping("delete/{cnum}")
	public void delete(@PathVariable Long cnum) {
		commentService.delete(cnum);
	}
}
