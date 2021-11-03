package com.example.demo2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo2.model.JpaMember;
import com.example.demo2.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberService memberservice;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("join")
	public String join() {
		return "join";
	}
	@PostMapping("join")
	public String join(JpaMember member) {
		memberservice.save(member);
		return "redirect:list";
	}
	@GetMapping("list")
	public String list(Model model, @PageableDefault(size=3,sort="id", direction=Sort.Direction.DESC )Pageable pageable) {
		//List<JpaMember> lists = memberservice.list();
		System.out.println("pageable : " +pageable);
		
		Page<JpaMember> lists = memberservice.list(pageable);
		model.addAttribute("lists",lists);
		return "list";
	}
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public Long list(@PathVariable Long id) {
		memberservice.delete(id);
		return id;
	}
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		//memberservice.detail(id);
		model.addAttribute("member", memberservice.detail(id));
		return "detail";
	}
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberservice.detail(id));
		return "update";
	}
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody JpaMember member) {
		memberservice.update(member);
		return "success";
	}
	
	
	
	
	
	
	
}
