package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonView extends AbstractController{
	private PersonDAOImpl dao;
	
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonDTO person = dao.personView(request.getParameter("id"));
		ModelAndView mv = new ModelAndView();
		mv.addObject("person",person);
		mv.setViewName("WEB-INF/jsp/personView.jsp");
		return mv;
	}

	

}
