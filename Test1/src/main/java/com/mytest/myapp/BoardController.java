package com.mytest.myapp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytest.dto.BoardDTO;
import com.mytest.dto.PageVO;
import com.mytest.model.BoardServiceImpl;


@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Autowired //생성된 객체를 주입
	private BoardServiceImpl service;
	
	//추가
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String callInsert() {
		return "board/boardInsert";
	}
	@PostMapping("insert")
	public String boardInsert(BoardDTO board) {
		service.insert(board);
		return "redirect:/board/list";
	}
	//전체보기
	@GetMapping({"list"})
	public String list(Model model, String pageNum, @RequestParam(name="field",defaultValue = "") String field, @RequestParam(name="word",defaultValue = "") String word) {
		
		int currentPage = pageNum == null? 1:Integer.parseInt(pageNum);
		int pageSize = 5;
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("pageStart", (currentPage-1)*pageSize);
		hm.put("pageSize", pageSize);				
		
		List<BoardDTO> list = service.findAll(hm);
		int count = service.getCount(hm);
		
		PageVO page = new PageVO(count, currentPage, pageSize);
		model.addAttribute("lists",list);
		model.addAttribute("count", count);
		model.addAttribute("p",page);
		return "board/boardList";
	}
	//상세보기
	@GetMapping("view/{num}")
	public String view(Model model, @PathVariable int num) {
		BoardDTO board = service.findByNum(num);
		service.readCount(num);
		model.addAttribute("board", board);
		return "board/view";
	}
	//수정 폼
	@GetMapping("update/{num}")
	public String update(Model model, @PathVariable int num) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
		return "board/update";
	}
	//수정
	@PutMapping("update")
	@ResponseBody //문자열로 인식
	public String update(@RequestBody BoardDTO board) {
		service.update(board);
		return "success";
	}
	//삭제
	@DeleteMapping("delete/{num}")
	@ResponseBody //문자열로 인식
	public String delete(@PathVariable int num) {
		service.delete(num);
		return "success";
	}
	
	
}
