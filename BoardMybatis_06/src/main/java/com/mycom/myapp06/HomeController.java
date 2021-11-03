package com.mycom.myapp06;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.PageVO;
import com.myboard.model.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired //생성된 객체를 주입
	private BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		
//		return "boardInsert";
//	}
	@GetMapping("insert")
	public String callInsert() {
		return "boardInsert";
	}
	@PostMapping("insert")
	public String boardInsert(BoardDTO board) {
		service.insert(board);
		return "redirect:/list";
	}
	//전체보기
	@GetMapping({"/","list"})
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
		return "boardList";
	}
	//상세보기
	@GetMapping("view/{num}")
	public String view(Model model, @PathVariable int num) {
		BoardDTO board = service.findByNum(num);
		service.readCount(num);
		model.addAttribute("board", board);
		return "view";
	}
	//수정 폼
	@GetMapping("update/{num}")
	public String update(Model model, @PathVariable int num) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
		return "update";
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
