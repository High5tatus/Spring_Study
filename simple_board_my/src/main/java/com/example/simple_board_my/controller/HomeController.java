package com.example.simple_board_my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_board_my.dto.BoardDTO;
import com.example.simple_board_my.service.BoardService;

@RestController
public class HomeController {
	@Autowired
	private BoardService bService;
	
	@PostMapping("api/insert")
	public String insert(@RequestBody BoardDTO board) {
		bService.insert(board);
		return "success";
	}
	@GetMapping("api/get")
	public List<BoardDTO> list(Model model) {
		return bService.findAll();
	}
}
