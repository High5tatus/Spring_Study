package com.mycom.myapp05;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myguest.model.GuestDTO;
import com.myguest.model.GuestListVO;
import com.myguest.model.GuestServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//@Autowired
	@Resource(name="service")
	private GuestServiceImpl service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "insert";
	}
	//추가
	@PostMapping("gInsert")
	@ResponseBody
	public String insert(@RequestBody GuestDTO guest, HttpServletRequest request) {
		guest.setIpaddr(request.getRemoteAddr());
		service.guestInsert(guest);
		return "success";
	}
	//전체보기
	@GetMapping("gList")
	@ResponseBody
	public GuestListVO list(@RequestParam(name="field",required = false) String field,
							@RequestParam(required = false) String word){
//		List<GuestDTO> list = service.list();
//		int count = service.count();
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<GuestDTO> list = service.guestList(hm);
		int count = service.guestCount(hm);
		GuestListVO listvo = new GuestListVO(count, list);
		return listvo;
	}
	//삭제
	@DeleteMapping("gDelete/{no}")
	@ResponseBody
	public String delete(@PathVariable("no") int num) {
		service.guestDelete(num);
		return "success";
	}
	//상세보기
	@GetMapping("gView")
	@ResponseBody
	public GuestDTO view(int num) {
		return service.findByNum(num);
	}
}
