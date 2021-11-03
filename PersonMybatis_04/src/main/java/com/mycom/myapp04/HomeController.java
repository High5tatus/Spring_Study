package com.mycom.myapp04;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.models.PersonServiceImpl;
import com.mycom.vo.PersonVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired //생성된 객체를 주입
	private PersonServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//추가 폼
	@GetMapping("per_insert")
	public String insert() {
		return "insert";
	}
	
	//추가
	@PostMapping("per_insert")//버전 5부터 가능
	public String insert(@ModelAttribute PersonVO person) {
		service.insert(person);
		return "redirect:per_list";
	}
	
	//전체보기
	@GetMapping("per_list")
	public String list(Model model, String field, String word) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		
//		List<PersonVO> personlist = service.list();
//		int count = service.count();
		
		List<PersonVO> personlist = service.list(hm);
		int count = service.count(hm);
		
		model.addAttribute("personlist",personlist);
		model.addAttribute("count", count);
		return "list";
		
	}
	
	//상세보기, 수정폼
	@GetMapping({"view","update"})
	public void view(Model model, String id) {
		PersonVO person  = service.view(id);
		model.addAttribute("person", person);
		
	}
	
	//수정
	@PostMapping("per_update")
	public String update(@ModelAttribute PersonVO person) {
		service.update(person);
		return "redirect:per_list";
	} 
	//삭제
	@GetMapping("per_delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:per_list";
	}
	
	
	
}