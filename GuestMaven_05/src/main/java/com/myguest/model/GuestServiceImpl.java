package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDAOImpl dao;
	
	@Override
	public void guestInsert(GuestDTO guest) {
		dao.dao_guestInsert(guest);		
	}

	@Override
	public List<GuestDTO> guestList(HashMap<String, String> hm) {
		return dao.dao_guestList(hm);
	}

	@Override
	public GuestDTO findByNum(int num) {
		return dao.dao_findByNum(num);
	}

	@Override
	public void guestUpdate(GuestDTO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guestDelete(int num) {
		dao.dao_guestDelete(num);
		
	}

	@Override
	public int guestCount(HashMap<String, String> hm) {
		return dao.dao_guestCount(hm);
	}
	
	public List<GuestDTO> list(){
		return dao.list(); 
	}
	public int count() {
		return dao.count();
	}
}
