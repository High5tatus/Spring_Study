package com.mycom.myapp07;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.model.BoardService;
import com.mysecurity.dto.BoardDTO;

import lombok.extern.java.Log;

/**
 * Handles requests for the application home page.
 */
@Log
@Controller
public class HomeController {
	@Autowired //생성된 객체를 주입
	private BoardService service;
	
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
		
		return "redirect:/board/list";
	}
	@GetMapping("customLogin")
	public void loginInput() {
		log.info("customLogin");
	}
	@GetMapping("admin")
	public void admin() {
		
	}
	@GetMapping("manager")
	public void manager() {
		
	}
	@GetMapping("all")
	public void all() {
		
	}
	@GetMapping("customLogout")
	public void customLogout() {
		
	}
	
}
