package com.example.test2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test2.model.Member;
import com.example.test2.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberService memberservice;
	@Autowired
	private PasswordEncoder pwencoder;

	@GetMapping("/")
	public String home() {
		return "redirect:list";
	}
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody Member member) {
		member.setPassword(pwencoder.encode(member.getPassword()));
		System.out.println(member.getAdmin().length());
		if(member.getAdmin().equals("1")) {
			System.out.println("role_admin");
			member.setAdmin("role_admin");
		}else {
			member.setAdmin("role_user");
		}
		memberservice.save(member);
		return "success";
	}

	// 아이디 중복확인 폼
	@GetMapping("idCheck")
	public String idCheck() {
		return "idCheck";
	}
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String username) {
		Member member= memberservice.idCheck(username);
		if(member==null) {
			return "yes";
		}
		return "no";
	}

	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("members", memberservice.list());
		return "member/memberList";
	}

	@DeleteMapping("delete/{id}")
	@ResponseBody
	public Long list(@PathVariable Long id) {
		memberservice.delete(id);
		return id;
	}

	@GetMapping("detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		// memberservice.detail(id);
		model.addAttribute("member", memberservice.detail(id));
		return "detail";
	}


}
