package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//상속받은것과 같은 역할을 함
public class TestController {
	@RequestMapping("test.go")
	public String test() {
		return "result";//result.jsp
	}
	
	@RequestMapping("test22.go")
	public String test2() {
		return "test";
	}
}
