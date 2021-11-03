package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysecurity.dto.BoardDTO;
import com.mysecurity.mapper.BoardMapper;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private BoardMapper bmapper;
	
	
	@Override
	public void dao_insert(BoardDTO board) {
		bmapper.insert(board);
		
	}


	@Override
	public List<BoardDTO> dao_list() {
		// TODO Auto-generated method stub
		return bmapper.findAll();
	}

}
