package com.mytest.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytest.dto.MemberDTO;
import com.mytest.model.MemberServiceImpl;


@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	private MemberServiceImpl mService;
	@Autowired
	private PasswordEncoder pwencoder;

	// 회원가입 폼
	@GetMapping("join")
	public void join() {
	}

	// 회원가입
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
		member.setUserpw(pwencoder.encode(member.getUserpw()));
		mService.join(member);		
		return "success";
	}

	// 아이디 중복확인 폼
	@GetMapping("idCheck")
	public String idCheck() {
		return "member/idCheck";
	}

	// 아이디 중복확인
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String userid) {
		int cnt = mService.idCheck(userid);
		if (cnt != 0)
			return "fail";// 아이디 중복
		return "yes";
	}

	// 로그인 폼
	@GetMapping("login")
	public String login() {
		return "/login";
	}
	
	
}
