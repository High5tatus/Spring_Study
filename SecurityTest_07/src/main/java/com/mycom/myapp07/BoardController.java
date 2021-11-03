package com.mycom.myapp07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myboard.model.BoardService;
import com.mysecurity.dto.BoardDTO;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
		return "board/insert";
	}
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		service.insert(board);
		return "redirect:/board/list";
	}
	@GetMapping("list")
	public String list(Model model) {
		List<BoardDTO>list = service.list();
		model.addAttribute("lists", list);
		return "board/list";
	}
}
