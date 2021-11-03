package com.mycom.myapp06;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.MemberDTO;
import com.myboard.model.MemberServiceImpl;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	private MemberServiceImpl mService;

	// 회원가입 폼
	@GetMapping("join")
	public void join() {
		// return "join";
	}

	// 회원가입
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
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
	public String idCheck(String id) {
		int cnt = mService.idCheck(id);
		if (cnt != 0)
			return "fail";// 아이디 중복

		return "yes";
	}

	// 로그인 폼
	@GetMapping("login")
	public String login() {
		return "member/login";
	}

	// 로그인
	@PostMapping("login")
	@ResponseBody
	public String login(String id, String pass, HttpSession session) {
		MemberDTO member = mService.loginCheck(id);
		String result = "no";//회원아님
		if(member!=null) { //회원
			if(member.getPass().equals(pass)) {//비번맞음
				session.setAttribute("sMember", member);
				result="success";
			}else {//비번틀림
				result="passFail";
			}
		}
		return result;
	}
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}

}
