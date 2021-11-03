package org.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.person.model.Person2DAOImpl;
import org.person.model.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
	@Autowired
	private Person2DAOImpl dao;//유형으로 자동 주입
	//추가폼
	@RequestMapping("personInsert.go")
	public String insertform() {
		return "personForm";// personForm.jsp
	}
	//추가(db에 추가)
	@RequestMapping(value="personInsert.go", method=RequestMethod.POST)
	public String insert(PersonVO person) {
		dao.person_insert(person);
		return "redirect:personList.go";
	}
	//전체보기
	@RequestMapping(value="personList.go", method = RequestMethod.GET)
	public String list(Model model) {
		List<PersonVO> userlist = dao.person_list();
		model.addAttribute("personlist",userlist);
		return "personList"; // personList.jsp
	}	
	
//	public ModelAndView list() {
//		ModelAndView mv = new ModelAndView();
//		List<PersonVO> userlist = dao.person_list();
//		mv.addObject("personlist",userlist);
//		mv.setViewName("personList");
//		return mv;
//	}
	
	//상세보기
	@RequestMapping({"personView.go", "personUpdate.go"})
	public void view(Model model, String id) {
		PersonVO person = dao.person_view(id);
		model.addAttribute("person",person);		
		//return "personView";
	}
	
//	public ModelAndView view(String id) {
//		ModelAndView mv = new ModelAndView();
//		PersonVO person = dao.person_view(id);		
//		mv.addObject("person",person);
//		mv.setViewName("personView");
//		return mv;
//	}
	//수정 폼
//	@RequestMapping("personUpdate.go")
//	public String update(Model model, String id) {
//		PersonVO person = dao.person_view(id);
//		model.addAttribute("person",person);		
//		return "personUpdate";
//	}
	
	//수정
	@RequestMapping(value = "personUpdate.go", method = RequestMethod.POST)
	public String update(PersonVO person) {
		dao.person_update(person);
		return "redirect:personList.go";
	}
	
	//삭제
	
	@RequestMapping("personDelete.go")
	public String delete(String id) {
		dao.person_delete(id);
		return "redirect:personList.go";
	}
	
	
	
	
	
}
