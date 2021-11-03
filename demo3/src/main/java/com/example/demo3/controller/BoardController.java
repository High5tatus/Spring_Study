package com.example.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo3.config.auth.PrincipalDetails;
import com.example.demo3.model.Board;
import com.example.demo3.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardservice;
	
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
		return "/board/insert";
	}
	@PostMapping("insert")
	public String insert(Board board, @AuthenticationPrincipal PrincipalDetails principal) {
		boardservice.insert(board, principal.getUser());
		return "redirect:/board/list";
	}
	//전체보기
//	@GetMapping("list")
//	public String list(Model model) {
//		model.addAttribute("lists", boardservice.list());
//		model.addAttribute("count", boardservice.count());
//		return "/board/list";
//	}
	//전체보기(페이징)
	@GetMapping("list")
	public String list(Model model, @PageableDefault(size=5,sort="num", direction=Sort.Direction.DESC )Pageable pageable) {
		Page<Board> lists =boardservice.findAll(pageable);
		model.addAttribute("lists", lists);
		model.addAttribute("count", boardservice.count());
		model.addAttribute("rowNo", boardservice.count()-(lists.getNumber()*5));
		return "/board/list";
	}
	
	
	
	@GetMapping("view/{num}")
	public String view(Model model, @PathVariable Long num) {
		model.addAttribute("board", boardservice.findById(num));
		return "/board/view";
	}
	@GetMapping("update/{num}")
	public String update(Model model, @PathVariable Long num) {
		model.addAttribute("board", boardservice.findById(num));
		return "/board/update";
	}
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Board	board) {
		boardservice.update(board);
		return "success";
	}
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable Long num) {
		boardservice.delete(num);
		return "success";
	}
}
