package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysecurity.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAOImpl dao;

	@Override
	public void insert(BoardDTO board) {
		// TODO Auto-generated method stub
		dao.dao_insert(board);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return dao.dao_list();
	}
	
	

}
