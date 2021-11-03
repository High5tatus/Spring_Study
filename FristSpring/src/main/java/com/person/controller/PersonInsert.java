package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonInsert extends AbstractController{
	private PersonDAOImpl dao;
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
		PersonDTO person = new PersonDTO();
		person.setId(request.getParameter("id"));
		person.setName(request.getParameter("name"));
		person.setGender(request.getParameter("gender"));
		person.setJob(request.getParameter("job"));
		person.setPassword(request.getParameter("password"));
		dao.personInsert(person);
		
		return new ModelAndView("redirect:/personList.sp");
	}
	

}
